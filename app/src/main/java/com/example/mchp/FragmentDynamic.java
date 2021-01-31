package com.example.mchp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class FragmentDynamic extends AppCompatActivity {

    FragmentCalendar frag1;
    FragmentColors frag2;
    Fragment current;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_dinamic_fragment);
        frag1 = new FragmentCalendar();
        frag2 = new FragmentColors();
    }

    // стандартный обработчик для фрагментов с функциями add, remove, replace
    @SuppressLint("NonConstantResourceId")
    public void onClickButton(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.btnAdd:
                fragmentManager.beginTransaction().add(R.id.frgmCont, frag1).commit();
                current = frag1;
                break;
            case R.id.btnRemove:
                fragmentManager.beginTransaction().remove(current).commit();
                break;
            case R.id.btnReplace:
                if (current == frag1) current = frag2;
                else if (current == frag2) current = frag1;
                fragmentManager.beginTransaction().replace(R.id.frgmCont, current).commit();
                break;
            default:
                break;
        }
    }
}

