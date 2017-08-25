package com.example.gabdullinae.wheatherapplication.mainactivity.citylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabdullinae.wheatherapplication.R;
import com.example.gabdullinae.wheatherapplication.detailinfoactivity.DetailInfoActivity;
import com.example.gabdullinae.wheatherapplication.model.City;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 14:40.
 */

public class CityListFragment extends Fragment implements CityListAdapter.OnCityClick, CityListView {
    public static final String CITY = "city";
    private static final String JSON_PATH = "city.list.json";
    private CityListPresenter presenter = new CityListPresenter(this);
    private List<City> cities = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        presenter.getCities();
        RecyclerView mCityRecyclerList = ((RecyclerView) view.findViewById(R.id.citiesRecyclerList));
        CityListAdapter mAdapterList = new CityListAdapter();
        mAdapterList.setOnCityClickListener(this);
        mCityRecyclerList.setAdapter(mAdapterList);
        mCityRecyclerList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapterList.setCities(cities);
    }

    @Override
    public void onCityClick(City c) {
        Intent intent = new Intent(getActivity(), DetailInfoActivity.class);
        intent.putExtra(CITY, new Gson().toJson(c));
        startActivity(intent);
    }

    @Override
    public void getCities() {
        Gson gson = new Gson();
        try {
            Scanner sc = new Scanner(getActivity().getAssets().open(JSON_PATH));
            while (sc.hasNext() && cities.size() < 100) {
                cities.add(gson.fromJson(sc.nextLine(), City.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
