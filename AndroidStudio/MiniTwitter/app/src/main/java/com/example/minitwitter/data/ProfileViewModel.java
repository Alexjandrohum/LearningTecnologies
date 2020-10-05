package com.example.minitwitter.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.minitwitter.retrofit.request.RequestUserProfile;
import com.example.minitwitter.retrofit.response.ResponseUserProfile;

public class ProfileViewModel extends AndroidViewModel {


    public ProfileRepository profileRepository;
    public LiveData<ResponseUserProfile> userProfile;
    public LiveData<String> photoProfile;


    public ProfileViewModel(@NonNull Application application){
        super(application);
        profileRepository = new ProfileRepository();

        userProfile = profileRepository.getProfile();
        photoProfile = profileRepository.getPhotoProfile();

    }

    public void UpdateProfile(RequestUserProfile requestUserProfile){

        profileRepository.UpdateProfile(requestUserProfile);

    }

    public void uploadProfile(String photo){
        profileRepository.uploadPhoto(photo);
    }

}
