package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;

import org.w3c.dom.Text;

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
                    R.layout.list_item, parent, false);
        }

        Quake currentQuake = getItem(position);

        String locationString;
        String offsetString;
        String city = currentQuake.getCity();
        if (city.contains("of")) {
            int index = city.indexOf("of");
            offsetString = city.substring(0, (index+2));
            locationString = city.substring((index+3), city.length());
        }
        else {
            offsetString = "Near the";
            locationString = city;
        }
        TextView offset = (TextView) quakeListView.findViewById(R.id.offset_text_view);
        offset.setText(offsetString);
        TextView location = (TextView) quakeListView.findViewById(R.id.location_text_view);
        location.setText(locationString);

        TextView magnitude = (TextView) quakeListView.findViewById(R.id.mag_text_view);
        magnitude.setText(formatMagnitude(currentQuake.getMagnitude()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView date = (TextView) quakeListView.findViewById(R.id.date_text_view);
        TextView time = (TextView) quakeListView.findViewById(R.id.time_text_view);
        Date dateObject = new Date(currentQuake.getDate());
        date.setText(formatDate(dateObject));
        time.setText(formatTime(dateObject));

        return quakeListView;
    }

    public String formatDate(Date dateObject){
        String date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        date = dateFormat.format(dateObject);
        return date;
    }

    public String formatTime(Date dateObject){
        String time;
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        time = timeFormat.format(dateObject);
        return time;
    }

    public String formatMagnitude(double magnitude) {
        DecimalFormat formater = new DecimalFormat("0.0");
        return formater.format(magnitude);
    }

    public int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
