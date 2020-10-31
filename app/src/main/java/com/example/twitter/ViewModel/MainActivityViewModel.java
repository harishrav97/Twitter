package com.example.twitter.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twitter.Model.TwitterModel;
import com.example.twitter.Repository.TwitterRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel  extends ViewModel {
    private MutableLiveData<List<TwitterModel>> mLiveData;
    private List<TwitterModel> tweetList;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();
    private TwitterRepository mRepo;
    public List<TwitterModel> getTweetList(){
        return  tweetList;
    }
    public void init(){
        if(tweetList != null){
            return;
        }
        mRepo = mRepo.getInstance();
        mIsUpdating.setValue(true);
        tweetList = mRepo.getTweetDetails();
        mIsUpdating.setValue(false);
    }
    public List<TwitterModel> filter(String text){
        List<TwitterModel> temp = new ArrayList();
        for(TwitterModel d: tweetList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        return temp;
    }

}
