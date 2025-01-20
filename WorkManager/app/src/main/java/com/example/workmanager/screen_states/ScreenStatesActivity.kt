package com.example.workmanager.screen_states

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.workmanager.databinding.ActivityScreenStatesBinding

class ScreenStatesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScreenStatesBinding
    private val viewModel: ScreenStatesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenStatesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyBindings()
        applyObservers()
    }

    private fun applyObservers() {
        viewModel.screenStates.observe(this) {
            binding.textView.visibility =
                ScreenStates.getVisibility(isVisible = (it == ScreenStates.LOADED))
            binding.progressCircular.visibility =
                ScreenStates.getVisibility(isVisible = (it == ScreenStates.LOADING))
            binding.retryButton.visibility =
                ScreenStates.getVisibility(isVisible = (it == ScreenStates.ERROR))
        }
    }

    private fun applyBindings() {
        binding.retryButton.setOnClickListener { viewModel.loadingTask(forceLoad = false) }
        binding.tryAgainButton.setOnClickListener { viewModel.loadingTask(forceLoad = true) }
    }
}