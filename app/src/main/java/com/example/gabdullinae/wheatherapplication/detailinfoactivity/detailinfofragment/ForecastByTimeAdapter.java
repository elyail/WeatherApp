package com.example.gabdullinae.wheatherapplication.detailinfoactivity.detailinfofragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabdullinae.wheatherapplication.R;
import com.example.gabdullinae.wheatherapplication.utils.IconUtils;
import com.example.gabdullinae.wheatherapplication.utils.TimeUtils;
import com.example.gabdullinae.wheatherapplication.model.forecast.HourlyForecast;

import java.util.List;

/**
 * Created by Elvira Gabdullina
 * on 12.11.2016, 14:53.
 */

class ForecastByTimeAdapter extends RecyclerView.Adapter<ForecastByTimeAdapter.ForecastViewHolder> {
    private List<HourlyForecast> forecastlist;

    ForecastByTimeAdapter(List<HourlyForecast> forecastlist) {
        this.forecastlist = forecastlist;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast_by_time, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ForecastViewHolder holder, final int position) {
        holder.tvTime.setText(TimeUtils.prettyTime(holder.tvTime.getContext(), forecastlist.get(position).dt));
        holder.temperature.setText(String.valueOf(forecastlist.get(position).main.temp + " °C"));
        holder.timeWeatherIcon.setImageDrawable(IconUtils.prettyIcon(holder.tvTime.getContext(),
                forecastlist.get(position).weather.get(0).icon));
    }

    @Override
    public int getItemCount() {
        return forecastlist.size();
    }

    static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView tvTime;
        ImageView timeWeatherIcon;
        TextView temperature;

        ForecastViewHolder(View itemView) {
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            timeWeatherIcon = (ImageView) itemView.findViewById(R.id.timeWeatherIcon);
            temperature = (TextView) itemView.findViewById(R.id.temperature);
        }
    }
}
