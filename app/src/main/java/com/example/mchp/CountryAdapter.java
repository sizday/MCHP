package com.example.mchp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    interface OnCountryClickListener {
        void onCountryClick(Country country, int position);
    }

    private final OnCountryClickListener onCountryClickListener;
    private final LayoutInflater layoutInflater;
    private final List<Country> countryList;

    public CountryAdapter(LayoutInflater layoutInflater, List<Country> countryList, OnCountryClickListener onCountryClickListener) {
        this.layoutInflater = layoutInflater;
        this.countryList = countryList;
        this.onCountryClickListener = onCountryClickListener;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycleview_block, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.flagView.setImageResource(country.getFlag());
        holder.countryView.setText(country.getCountry());
        holder.capitalView.setText(country.getCapital());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCountryClickListener.onCountryClick(country, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView countryView;
        final TextView capitalView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flagView = itemView.findViewById(R.id.imageFlag);
            countryView = itemView.findViewById(R.id.textCountry);
            capitalView = itemView.findViewById(R.id.textCapital);
        }
    }
}
