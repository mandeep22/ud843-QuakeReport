package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by JammuMn on 8/15/2016.
 */
public class QuakeAdapter extends ArrayAdapter<Quake> {
    public QuakeAdapter(Context context, ArrayList<Quake> quakes) {
        super(context, 0, quakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View quakeListView = convertView;
        if (quakeListView == null) {
            quakeListView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_activity, parent, false);
        }

        Quake currentQuake = getItem(position);

        return super.getView(position, convertView, parent);
    }
}
