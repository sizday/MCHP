package com.example.mchp.material_design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mchp.R;
import com.example.mchp.fragments.FragmentCalendar;
import com.example.mchp.fragments.FragmentListLessons;
import com.example.mchp.fragments.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigationExample extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    Fragment fragment_profile, fragment_list_lessons;
    FragmentCalendar fragment_calendar;
    Boolean fragFlag1 = false, fragFlag2 = false, fragFlag3 = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        fragment_list_lessons = new FragmentListLessons();
        fragment_profile = new FragmentProfile();
        fragment_calendar = new FragmentCalendar();
        openFragment(fragment_profile);

        // подсказка запускается с помощью CTRL+O
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_profile:
                        openFragment(fragment_profile);
                        return true;
                    case R.id.menu_list_lesson:
                        openFragment(fragment_list_lessons);
                        return true;
                    case R.id.menu_3:
                        return true;
                }
                return true;
            }
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    // функция установки меню на layout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    // обработка кнопки перехода на новый layout с передачей данных из editView
    // на данный момент оставлена только для демонстрации, практически не имеет ценности
    public void onClick(View view) {
        EditText editText = findViewById(R.id.editTextPersonName);
        String name = editText.getText().toString();
        Intent intent = new Intent(BottomNavigationExample.this, ListLessons.class);
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
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        String phoneNumber = editTextNumber.getText().toString();
        if(!TextUtils.isEmpty(phoneNumber)) {
            String dial = "tel:" + phoneNumber;
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(dial));
            startActivity(intent);
        }
    }

    // функция логика работы фрагментов
    public boolean fragLogic(Button btn, boolean flag, int cont, Fragment current_frag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (!flag) {
            fragmentManager.beginTransaction().add(cont, current_frag).commit();
            flag = true;
            btn.setText(R.string.close);
        } else {
            fragmentManager.beginTransaction().remove(current_frag).commit();
            flag = false;
            btn.setText(R.string.open);
        }
        return flag;
    }

    // обработка кнопок и запуск для каждой функцию логики фрагментов с соответствующими параметрами
    @SuppressLint("NonConstantResourceId")
    public void onClickOpen(View v) {
        Button btnOpen1 = findViewById(R.id.btnOpen1);
        Button btnOpen2 = findViewById(R.id.btnOpen2);
        Button btnOpen3 = findViewById(R.id.btnOpen3);
        switch (v.getId()) {
            case R.id.btnOpen1:
                fragFlag1 = fragLogic(btnOpen1, fragFlag1, R.id.frgmCont1, fragment_calendar);
                break;
            case R.id.btnOpen2:
                fragFlag2 = fragLogic(btnOpen2, fragFlag2, R.id.frgmCont2, fragment_calendar);
                break;
            case R.id.btnOpen3:
                fragFlag3 = fragLogic(btnOpen3, fragFlag3, R.id.frgmCont3, fragment_calendar);
                break;
            default:
                break;
        }
    }

}