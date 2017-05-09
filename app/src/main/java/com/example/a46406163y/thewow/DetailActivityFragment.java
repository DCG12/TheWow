package com.example.a46406163y.thewow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.databinding.DataBindingUtil;

import com.example.a46406163y.thewow.databinding.FragmentDetailBinding;


public class DetailActivityFragment extends Fragment {

    private View view;
    private TextView lvWowName;
    private TextView lvWowLevel;
    private TextView lvWowHealt;
    private TextView lvWowDescrpt;
    private FragmentDetailBinding binding;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        View view = binding.getRoot();

        Intent i = getActivity().getIntent();

        if (i != null) {
            WOW wow = (WOW) i.getSerializableExtra("wow");

            if (wow != null) {
                updateUi(wow);
            }
        }

        return view;
    }

    private void updateUi(WOW wow) {
        Log.d("BOSS", wow.toString());

        int level = wow.getLevel();
        String lvl = Integer.toString(level);
        int healt = wow.getHealth();
        String hlt = Integer.toString(healt);

        binding.lvWowName.setText(wow.getName());
        binding.lvWowLvl.setText(lvl);
        binding.lvWowHealt.setText(hlt);
        binding.lvWowDesc.setText(wow.getDescription());
    }

}
