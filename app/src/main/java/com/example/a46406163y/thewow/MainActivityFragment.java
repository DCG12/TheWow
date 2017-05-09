package com.example.a46406163y.thewow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import nl.littlerobots.cupboard.tools.provider.UriHelper;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;
import android.app.ProgressDialog;
import com.example.a46406163y.thewow.databinding.FragmentMainBinding;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    private ArrayList<WOW> items;
    private WowAdapter adapter;
    private ProgressDialog dialog;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);


        View view = binding.getRoot();

        items = new ArrayList<>();
        adapter = new WowAdapter(
                getContext(),
                R.layout.lv_wow_row,
                items
        );

        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Cargando...");

        binding.lvWow.setAdapter(adapter);

        binding.lvWow.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WOW wow = (WOW) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getContext(), DetailActivity.class);

                intent.putExtra("wow", wow);

                startActivity(intent);
            }
        }
        );
        return view;
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_wow_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void refresh() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }
    private class RefreshDataTask extends AsyncTask<Void, Object, ArrayList<WOW>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected ArrayList<WOW> doInBackground(Void... voids) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            String level = preferences.getString("level", "80");
            String tipusConsulta = preferences.getString("tipus_consulta", "level");
            APIWOW api = new APIWOW();
            ArrayList<WOW> result =null;
            if (tipusConsulta.equals("level")) {
                result = api.getLevelBoss(level);
            } else {
                result = api.getLevelBoss(level);
            }

            Log.d("DEBUG", result.toString());

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<WOW> wow) {

            super.onPostExecute(wow);

            adapter.clear();
            for (int i = 0; i < wow.size(); i++) {
                adapter.addAll(wow.get(i));
            }
            dialog.dismiss();
        }
    }
}
