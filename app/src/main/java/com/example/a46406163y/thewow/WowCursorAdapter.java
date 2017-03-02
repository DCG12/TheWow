package com.example.a46406163y.thewow;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;



public class WowCursorAdapter extends CupboardCursorAdapter<WOW>{

    public WowCursorAdapter(Context context, Class<WOW> entityClass) {
        super(context, entityClass);
    }

    @Override
    public View newView(Context context, WOW model, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, WOW model) {

    }
}
