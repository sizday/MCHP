package com.example.mchp.fragment_manager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mchp.R;
import com.example.mchp.fragments.FragmentCalendar;
import com.example.mchp.fragments.FragmentColors;


public class FragmentExample extends AppCompatActivity {

    Fragment frag1;
    Fragment frag2;
    Fragment current;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fragment_example);
        frag1 = new FragmentCalendar();
        frag2 = new FragmentColors();
    }

    // стандартный обработчик для фрагментов с функциями add, remove, replace
    @SuppressLint("NonConstantResourceId")
    public void onClickButton(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (view.getId()) {
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

