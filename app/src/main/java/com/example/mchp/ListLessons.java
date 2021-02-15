package com.example.mchp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListLessons extends AppCompatActivity {
    FragmentCalendar frag1;
    FragmentColors frag2;
    Boolean fragFlag1 = false;
    Boolean fragFlag2 = false;
    Boolean fragFlag3 = false;

    // создание активити с приемом данных из intent
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_lessons);
        String name = getIntent().getStringExtra("name");
        Student kolyan = (Student) getIntent().getSerializableExtra("student");
        TextView textView = findViewById(R.id.helloTextView);
        textView.setText("Hello" + name);
        frag1 = new FragmentCalendar();
        frag2 = new FragmentColors();
    }

    // функция логика работы фрагментов
    public boolean fragLogic(Button btn, boolean flag, int cont) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (!flag) {
            fragmentManager.beginTransaction().add(cont, frag1).commit();
            flag = true;
            btn.setText(R.string.close);
        } else {
            fragmentManager.beginTransaction().remove(frag1).commit();
            flag = false;
            btn.setText(R.string.open);
        }
        return flag;
    }

    // обработка кнопок и запуск для каждой функцию логики фрагментов с соответствующими параметрами
    @SuppressLint("NonConstantResourceId")
    public void onClickButton(View v) {
        Button btnOpen1 = findViewById(R.id.btnOpen1);
        Button btnOpen2 = findViewById(R.id.btnOpen2);
        Button btnOpen3 = findViewById(R.id.btnOpen3);
        switch (v.getId()) {
            case R.id.btnOpen1:
                fragFlag1 = fragLogic(btnOpen1, fragFlag1, R.id.frgmCont1);
                break;
            case R.id.btnOpen2:
                fragFlag2 = fragLogic(btnOpen2, fragFlag2, R.id.frgmCont2);
                break;
            case R.id.btnOpen3:
                fragFlag3 = fragLogic(btnOpen3, fragFlag3, R.id.frgmCont3);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu2, menu);
        return true;
    }

}