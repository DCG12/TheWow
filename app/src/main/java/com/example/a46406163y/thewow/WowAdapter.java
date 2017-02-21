package com.example.a46406163y.thewow;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


public class WowAdapter extends ArrayAdapter<WOW> {

    public WowAdapter(Context context, int resource, List<WOW> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

         WOW wow = getItem(position);
        Log.w("XXXX", wow.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_wow_row, parent, false);
        }

        TextView lvCardName = (TextView) convertView.findViewById(R.id.lvWowName);

        lvCardName.setText(wow.getName());

        return convertView;
    }

}
