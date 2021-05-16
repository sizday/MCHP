package com.example.mchp.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.mchp.R;

// SharedPreferences
public class SharedPreferencesTest extends AppCompatActivity {

    private static final String MY_SETTINGS = "my_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // экземпляп класса для взаимодействия с памятью телефона
        SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);

        // очистка SharedPreferences
        // sp.edit().clear().apply();

        // получение данных
        boolean hasVisited = sp.getBoolean("hasVisited", false);

        // добавление данных
        if (!hasVisited) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("hasVisited", true).apply();
            setContentView(R.layout.shared_preference1);
        }
        else {
            setContentView(R.layout.shared_preference2);
        }
    }
}