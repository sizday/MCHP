package com.example.mchp.recycle_base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mchp.R;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    interface OnStateClickListener {
        void onStateClick(State state, int position);
    }

    private final OnStateClickListener onStateClickListener;
    private final LayoutInflater layoutInflater;
    private final List<State> stateList;

    public StateAdapter(LayoutInflater layoutInflater, List<State> stateList, OnStateClickListener onStateClickListener) {
        this.layoutInflater = layoutInflater;
        this.stateList = stateList;
        this.onStateClickListener = onStateClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {
        State state = stateList.get(position);
        holder.flagView.setImageResource(state.getFlag());
        holder.countryView.setText(state.getState());
        holder.capitalView.setText(state.getCapital());
        holder.radiobutton.setChecked(state.isRadio());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStateClickListener.onStateClick(state, position);
            }
        });
    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycleview_block, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView countryView;
        final TextView capitalView;
        final RadioButton radiobutton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flagView = itemView.findViewById(R.id.imageFlag);
            countryView = itemView.findViewById(R.id.textCountry);
            capitalView = itemView.findViewById(R.id.textCapital);
            radiobutton = itemView.findViewById(R.id.radioButton);
        }
    }
}

