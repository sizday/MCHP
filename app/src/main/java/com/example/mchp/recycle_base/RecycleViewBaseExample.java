package com.example.mchp.recycle_base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mchp.R;

import java.util.ArrayList;

public class RecycleViewBaseExample extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_base);
        states.add(new State("Russia", "Moscow", R.drawable.russia, true));
        states.add(new State("Ukraine", "Kiev", R.drawable.ukraine, false));
        states.add(new State("Belarus", "Minsk", R.drawable.belarus, true));
        updateData();
    }

    public void updateData() {
        RecyclerView recyclerView = findViewById(R.id.recycleViewState);
        StateAdapter.OnStateClickListener onStateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {
                // написать что-то что работает при нажатии
                updateData();
            }
        };
        StateAdapter stateAdapter = new StateAdapter(getLayoutInflater(), states, onStateClickListener);
        recyclerView.setAdapter(stateAdapter);
    }
}