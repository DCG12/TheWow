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

public class DetailActivityFragment extends Fragment {

    private View view;
    private TextView lvWowName;
    private TextView lvWowLevel;
    private TextView lvWowHealt;
    private TextView lvWowDescrpt;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_detail, container, false);

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

        lvWowName = (TextView) view.findViewById(R.id.lvWowName);
        lvWowLevel = (TextView) view.findViewById(R.id.lvWowLvl);
        lvWowHealt = (TextView) view.findViewById(R.id.lvWowHealt);
        lvWowDescrpt = (TextView) view.findViewById(R.id.lvWowDesc);

        lvWowName.setText(wow.getName());
        lvWowLevel.setText(lvl);
        lvWowHealt.setText(hlt);
        lvWowDescrpt.setText(wow.getDescription());
    }

}
