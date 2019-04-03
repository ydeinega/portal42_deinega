package com.example.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.model.Campus;
import com.example.model.CursusUsers;
import com.example.model.Model;
import com.example.model.User;
import com.example.network.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private ObservableField<String> login = new ObservableField<>();
    private MutableLiveData<Boolean> userSearchStatus = new MutableLiveData<>();

    public void searchButtonClicked() {

        if (getLogin() != null)
            searchUser(getLogin().get());
    }

    public void searchUser(final String login) {

        NetworkService.getInstance()
                .getApi42()
                .getUser(login)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {

                        if (response.isSuccessful()) {
                            User user = response.body();
                            Model.getInstance().setUser(user);
                            if (user != null) {
                                Log.i("Response for getUser", "SUCCESS");
                            }
                        } else {
                            Log.i("Response for getUser", "FAILURE");
                            userSearchStatus.setValue(false);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    private float level() {
        List<CursusUsers> cursusUsers = Model.getInstance().user.cursusUsers;
        for (int i = 0; i < cursusUsers.size(); i++) {
            if (cursusUsers.get(i).cursusId == 1)
                return cursusUsers.get(i).level;
        }
        return cursusUsers.get(0).level;
    }

    public String getLocation() {
        List<Campus> campuses = Model.getInstance().user.campus;
        String location = "";

        for (int i = 0; i < campuses.size(); i++) {
            location += i > 0 ? (", " + campuses.get(i).name) : campuses.get(i).name;
        }
        return location;
    }

    public String getLevel() { return "Level " + level(); }

    public String getGrade() { return Model.getInstance().user.cursusUsers.get(0).grade; }

    public String getWallet() {
        return String.valueOf(Model.getInstance().user.wallet);
    }

    public String getEvaluationPoints() { return String.valueOf(Model.getInstance().user.correctionPoint); }

    public String getCursus() {
        return Model.getInstance().user.cursusUsers.get(0).cursus.name;
    }

    public String getAchievNum() { return String.valueOf(Model.getInstance().user.achievements.size()); }

    public String getPhone() {
        return Model.getInstance().user.phone;
    }

    public String getEmail() {
        return Model.getInstance().user.email;
    }

    public String getStartDate() { return Model.getInstance().user.poolMonth + ", " + Model.getInstance().user.poolYear; }

    public LiveData<Boolean> getUserSearchStatus() { return userSearchStatus; }

    public ObservableField<String> getLogin() {
        return login;
    }

    public void setLogin(ObservableField<String> login) {
        this.login = login;
    }

    public LiveData<User> getUser() {
        return Model.getInstance().mUser;
    }

    public Drawable getUserPhoto() {
        return new BitmapDrawable(Model.getInstance().userPhoto);
    }

    public String getDisplayName() {
        return Model.getInstance().user.displayName;
    }
}