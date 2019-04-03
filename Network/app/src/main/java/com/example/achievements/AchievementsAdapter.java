package com.example.achievements;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Achievements;
import com.example.model.Model;
import com.example.network.NetworkService;
import com.example.network.R;
import com.example.network.Utils;

import java.net.URL;


public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.AchievementsViewHolder> {
    private int numberItems;

    public AchievementsAdapter(int numberItems) {
        this.numberItems = numberItems;
    }

    @NonNull
    @Override
    public AchievementsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.item_achievement;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        AchievementsViewHolder viewHolder = new AchievementsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementsViewHolder numberViewHolder, int i) {
        numberViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }


    public class AchievementsViewHolder extends RecyclerView.ViewHolder {

        TextView nameView;
        TextView descriptionView;
        TextView tierView;
        ImageView imageView;

        public AchievementsViewHolder(View itemView) {

            super(itemView);
            nameView = itemView.findViewById(R.id.tv_achievement_name);
            descriptionView = itemView.findViewById(R.id.tv_achievement_description);
            tierView = itemView.findViewById(R.id.tv_achievement_tier);
            imageView = itemView.findViewById(R.id.iv_achievement);
        }

        void bind(int listIndex) {

            Achievements achievement = Model.getInstance().user.achievements.get(listIndex);

            nameView.setText(achievement.name);
            descriptionView.setText(achievement.description);
            tierView.setText(achievement.tier);
            //imageView.setImageBitmap(NetworkService.getInstance().downloadImage(achievement.imageUrl));

            String url = NetworkService.BASE_DOWNLOAD_URL + achievement.imageUrl;

            Utils.fetchSvg(this, url, imageView);
        }
    }
}

