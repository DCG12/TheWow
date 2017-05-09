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
import android.databinding.DataBindingUtil;
import com.example.a46406163y.thewow.databinding.LvWowRowBinding;


public class WowAdapter extends ArrayAdapter<WOW> {

    public WowAdapter(Context context, int resource, List<WOW> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

         WOW wow = getItem(position);
        Log.w("XXXX", wow.toString());

        LvWowRowBinding binding;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.lv_wow_row, parent, false);
        }
        else {
            binding = DataBindingUtil.getBinding(convertView);
        }

        binding.lvWowName.setText(wow.getName());
        int level = wow.getLevel();
        String lvl = Integer.toString(level);
        binding.lvWowLvl.setText(lvl);

        return binding.getRoot();
    }

}
