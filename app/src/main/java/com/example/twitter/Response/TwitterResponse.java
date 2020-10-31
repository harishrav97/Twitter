package com.example.twitter.Response;

import com.example.twitter.Model.TwitterModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TwitterResponse {

    @SerializedName("data")
    @Expose
    private List<TwitterModel> data;

    @SerializedName("success")
    @Expose
    private String success;

    public List<TwitterModel> getData ()
    {
        return data;
    }

    public void setData (List<TwitterModel> data)
    {
        this.data = data;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", success = "+success+"]";
    }
}
