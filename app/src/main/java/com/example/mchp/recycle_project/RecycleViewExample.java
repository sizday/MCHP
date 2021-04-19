package com.example.mchp.recycle_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mchp.R;

import java.util.ArrayList;

public class RecycleViewExample extends AppCompatActivity {

    ArrayList<Country> countries = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        newStateRecycle();
    }

    private String getCountryArray(String searchCountry) {
        String[] allCountry = getResources().getStringArray(R.array.countries);
        String needCountry = "empty";

        for (String country : allCountry) {
            String[] splited = country.split(";");
            if (searchCountry.equals(splited[1]))
                needCountry = country;
        }
        return needCountry;
    }

    private void newStateRecycle() {
        RecyclerView recyclerView = findViewById(R.id.recycleViewCountry);
        CountryAdapter.OnCountryClickListener countryClickListener = new CountryAdapter.OnCountryClickListener() {
            @Override
            public void onCountryClick(Country country, int position) {
                countries.get(position).setChecked(!country.isChecked());
                newStateRecycle();
            }
        };
        CountryAdapter adapter = new CountryAdapter(getLayoutInflater(), countries, countryClickListener);
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
                    countries.add(new Country(countryInfo[1], countryInfo[2], resID, false));
                    break;
                case R.id.buttonDeleteCountry:
                    textView.setText("Deleted country is " + countryInfo[1]);
                    for (Country state : countries) {
                        if (state.getCountry().equals(countryInfo[1])) {
                            countries.remove(state);
                            break;
                        }
                    }
            }
            newStateRecycle();
        }
    }
}