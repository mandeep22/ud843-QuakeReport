package com.example.android.quakereport;

/**
 * Created by JammuMn on 8/15/2016.
 */
public class Quake {
    private String mCity;
    private double mMagnitude;
    private long mDate;

    public Quake(String city, double magnitude, long date) {
        mCity = city;
        mMagnitude = magnitude;
        mDate = date;
    }

    public String getCity() {
        return mCity;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public long getDate() {
        return mDate;
    }
}
