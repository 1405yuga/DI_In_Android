package com.example.workmanager.screen_states

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workmanager.databinding.ActivityScreenStatesBinding

class ScreenStatesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScreenStatesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenStatesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}