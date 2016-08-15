package com.example.android.quakereport;

/**
 * Created by JammuMn on 8/15/2016.
 */
public class Quake {
    private String mCity;
    private String mMagnitude;
    private int mDate;

    public Quake(String city, String magnitude, int date) {
        mCity = city;
        mMagnitude = magnitude;
        mDate = date;
    }

    public String getCity() {
        return mCity;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public int getDate() {
        return mDate;
    }
}
