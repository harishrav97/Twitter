package com.example.twitter.Model;

public class TwitterModel {
    private String name;

    private String handle;

    private String text;

    private String profileImageUrl;

    private String retweetCount;

    private String favoriteCount;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getHandle ()
    {
        return handle;
    }

    public void setHandle (String handle)
    {
        this.handle = handle;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getProfileImageUrl ()
    {
        return profileImageUrl;
    }

    public void setProfileImageUrl (String profileImageUrl)
    {
        this.profileImageUrl = profileImageUrl;
    }

    public String getRetweetCount ()
    {
        return retweetCount;
    }

    public void setRetweetCount (String retweetCount)
    {
        this.retweetCount = retweetCount;
    }

    public String getFavoriteCount ()
    {
        return favoriteCount;
    }

    public void setFavoriteCount (String favoriteCount)
    {
        this.favoriteCount = favoriteCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", handle = "+handle+", text = "+text+", profileImageUrl = "+profileImageUrl+", retweetCount = "+retweetCount+", favoriteCount = "+favoriteCount+"]";
    }
}
