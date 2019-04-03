package com.example.model;

import android.arch.lifecycle.MutableLiveData;
import android.graphics.Bitmap;

import com.example.network.NetworkService;

public class Model {

    public MutableLiveData<User> mUser = new MutableLiveData<>();
    private static Model mInstance;
    public Bitmap userPhoto;
    public User user;

    public void setUser(User user) {
        this.mUser.setValue(user);
        this.user = user;
        if (this.user != null)
            this.userPhoto = NetworkService.getInstance().downloadImage(user.imageUrl);
    }

    private Model() {}

    public static Model getInstance() {
        if (mInstance == null) {
            mInstance = new Model();
        }
        return mInstance;
    }

}
