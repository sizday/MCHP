package com.example.mchp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        newStateRecycle();
    }

    private String getCountryArray(String searchCountry) {
        String[] countries = getResources().getStringArray(R.array.countries);
        String needCountry = "empty";
        for (String country : countries) {
            String[] splited = country.split(";");
            if (searchCountry.equals(splited[1]))
                needCountry = country;
        }
        return needCountry;
    }


    private void newStateRecycle() {
        RecyclerView recyclerView = findViewById(R.id.recycleViewCountry);
        StateAdapter adapter = new StateAdapter(getLayoutInflater(), states);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint({"ShowToast", "SetTextI18n", "NonConstantResourceId"})
    public void onClickCountry(View view) {
        EditText editText = findViewById(R.id.editTextCountryName);
        TextView textView = findViewById(R.id.countryInfo);
        String country = editText.getText().toString();
        String countryInfoRaw = getCountryArray(country);
        if (countryInfoRaw.equals("empty")) {
            textView.setText("No such country");
        }
        else {
            String[] countryInfo = countryInfoRaw.split(";");
            switch (view.getId()) {
                case R.id.buttonAddCountry:
                    textView.setText("New country is " + countryInfo[1]);
                    int resID = getResources().getIdentifier(countryInfo[0], "drawable", getPackageName());
                    states.add(new State(countryInfo[1], countryInfo[2], resID));
                    break;
                case R.id.buttonDeleteCountry:
                    textView.setText("Deleted country is " + countryInfo[1]);
                    for (State state : states) {
                        if (state.getCountry().equals(countryInfo[1])) {
                            states.remove(state);
                            break;
                        }
                    }
            }
            newStateRecycle();
        }
    }
}