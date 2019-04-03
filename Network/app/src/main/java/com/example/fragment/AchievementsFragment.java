package com.example.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achievements.AchievementsAdapter;
import com.example.model.Model;
import com.example.network.R;

public class AchievementsFragment extends Fragment {

    private AchievementsViewModel mViewModel;
    AchievementsAdapter achievementsAdapter;
    RecyclerView achievementsList;

    public static AchievementsFragment newInstance() {
        return new AchievementsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_achievements, container, false);

        //change this after
        int numberListItems = Model.getInstance().user.achievements.size();
        achievementsList = (RecyclerView)view.findViewById(R.id.rv_achievements);
        achievementsAdapter = new AchievementsAdapter(numberListItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        achievementsList.setLayoutManager(layoutManager);
        achievementsList.setHasFixedSize(true);
        achievementsList.setAdapter(achievementsAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AchievementsViewModel.class);
        // TODO: Use the ViewModel
    }

}
