package com.example.mchp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final List<State> stateList;

    public StateAdapter(LayoutInflater layoutInflater, List<State> stateList) {
        this.layoutInflater = layoutInflater;
        this.stateList = stateList;
    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycleview_block, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {
        State state = stateList.get(position);
        holder.flagView.setImageResource(state.getFlag());
        holder.countryView.setText(state.getCountry());
        holder.capitalView.setText(state.getCapital());
    }

    @Override
    public int getItemCount() {
        return stateList.size();
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
