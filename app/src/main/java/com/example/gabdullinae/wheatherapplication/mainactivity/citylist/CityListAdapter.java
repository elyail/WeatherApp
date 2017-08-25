package com.example.gabdullinae.wheatherapplication.mainactivity.citylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gabdullinae.wheatherapplication.R;
import com.example.gabdullinae.wheatherapplication.model.City;

import java.util.List;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 14:40.
 */

class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CityViewHolder> {
    private List<City> cities;
    private OnCityClick listener;

    void setOnCityClickListener(OnCityClick listener) {
        this.listener = listener;
    }

    void setCities(List<City> cities) {
        this.cities = cities;
        notifyDataSetChanged();
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CityViewHolder holder, int position) {
        holder.cityName.setText(cities.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCityClick(cities.get(holder.getAdapterPosition()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    static class CityViewHolder extends RecyclerView.ViewHolder {
        TextView cityName;

        CityViewHolder(View itemView) {
            super(itemView);
            cityName = (TextView) itemView.findViewById(R.id.cityName);
        }
    }

    interface OnCityClick {
        void onCityClick(City c);
    }
}
