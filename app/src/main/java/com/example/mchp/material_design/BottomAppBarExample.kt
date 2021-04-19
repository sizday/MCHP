package com.example.mchp.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mchp.R
import com.example.mchp.databinding.ActivityMainBinding


class BottomAppBarExample : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // как использовать binding (помогает избежать многократного повторения findViewByID)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle search icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }
        setContentView(binding.root)
    }
}