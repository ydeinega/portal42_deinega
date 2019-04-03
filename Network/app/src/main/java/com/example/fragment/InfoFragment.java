package com.example.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.network.NetworkService;
import com.example.network.R;
import com.example.network.databinding.ActivityMainBinding;
import com.example.network.databinding.FragmentInfoBinding;
import com.example.viewmodel.MainViewModel;

public class InfoFragment extends Fragment {

    private MainViewModel mainViewModel;
    private FragmentInfoBinding fragmentInfoBinding;

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //inflater.inflate(R.layout.fragment_info, container, false);
        fragmentInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, null,false);
        return fragmentInfoBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        fragmentInfoBinding.setMainViewModel(mainViewModel);
    }

}
