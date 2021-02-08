package com.example.mchp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.util.ICUUncheckedIOException;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    final String LOG_TAG = "myLogs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate");
    }


    // функция установки меню на layout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_LONG).show();
    }

    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }


    // обработка кнопки перехода на новый layout с передачей данных из editView
    public void onClick(View view) {
        EditText editText = findViewById(R.id.editTextPersonName);
        String name = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, ListLessons.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    // обработка кнопки перехода по ссылке
    public void onClickVK(View view) {
        Uri address = Uri.parse("https://vk.com/1denis9");
        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
        if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(openLinkIntent);
        }
    }

    // обработка кнопки открытия звонка
    public void onClickTel(View view) {
        String phoneNo = "89307014255";
        if(!TextUtils.isEmpty(phoneNo)) {
            String dial = "tel:" + phoneNo;
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(dial));
            startActivity(intent);
        }
    }
}