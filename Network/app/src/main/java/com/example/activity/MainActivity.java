package com.example.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.model.User;
import com.example.network.NetworkService;
import com.example.network.R;
import com.example.network.Token;
import com.example.network.databinding.ActivityMainBinding;
import com.example.viewmodel.MainViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (NetworkService.TOKEN == null) {

            NetworkService.getInstance()
                    .getIntra42Api()
                    .getToken("client_credentials", NetworkService.UID, NetworkService.SECRET)
                    .enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(@NonNull Call<Token> call, @NonNull Response<Token> response) {

                            NetworkService.getInstance().initToken(response.body());
                            Log.i("TOKEN", NetworkService.TOKEN);
                        }

                        @Override
                        public void onFailure(@NonNull Call<Token> call, @NonNull Throwable t) {
                            t.printStackTrace();
                        }
                    });
        }

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        activityMainBinding.setMainViewModel(mainViewModel);
        userChangeListener();
        userStatusListener();

    }

    private void userChangeListener(){

        mainViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void userStatusListener() {

        mainViewModel.getUserSearchStatus().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {

                try {
                    if (!aBoolean)
                        Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

