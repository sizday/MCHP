package com.example.mchp.material_design

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mchp.R
import com.example.mchp.fragments.FragmentCalendar
import com.example.mchp.fragments.FragmentColors

// пример класса переработанного в KOTLIN
class ListLessons : AppCompatActivity() {
    var frag1: FragmentCalendar? = null
    var frag2: FragmentColors? = null
    var fragFlag1 = false
    var fragFlag2 = false
    var fragFlag3 = false

    // создание активити с приемом данных из intent
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_lessons)
        val name = intent.getStringExtra("name")
        val textView = findViewById<TextView>(R.id.helloTextView)
        textView.text = "Hello$name"
        frag1 = FragmentCalendar()
        frag2 = FragmentColors()
    }

    // функция логика работы фрагментов
    fun fragLogic(btn: Button, flag: Boolean, cont: Int): Boolean {
        var flag = flag
        val fragmentManager = supportFragmentManager
        if (!flag) {
            fragmentManager.beginTransaction().add(cont, frag1!!).commit()
            flag = true
            btn.setText(R.string.close)
        } else {
            fragmentManager.beginTransaction().remove(frag1!!).commit()
            flag = false
            btn.setText(R.string.open)
        }
        return flag
    }

    // обработка кнопок и запуск для каждой функцию логики фрагментов с соответствующими параметрами
    @SuppressLint("NonConstantResourceId")
    fun onClickButton(v: View) {
        val btnOpen1 = findViewById<Button>(R.id.btnOpen1)
        val btnOpen2 = findViewById<Button>(R.id.btnOpen2)
        val btnOpen3 = findViewById<Button>(R.id.btnOpen3)
        when (v.id) {
            R.id.btnOpen1 -> fragFlag1 = fragLogic(btnOpen1, fragFlag1, R.id.frgmCont1)
            R.id.btnOpen2 -> fragFlag2 = fragLogic(btnOpen2, fragFlag2, R.id.frgmCont2)
            R.id.btnOpen3 -> fragFlag3 = fragLogic(btnOpen3, fragFlag3, R.id.frgmCont3)
            else -> {
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu2, menu)
        return true
    }
}