package com.example.workmanager.screen_states

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class ScreenStatesViewModel : ViewModel() {
    val TAG = this::class.simpleName
    private val _screenStates: MutableLiveData<ScreenStates> = MutableLiveData(ScreenStates.LOADED)
    val screenStates: LiveData<ScreenStates> = _screenStates

    fun loadingTask(forceLoad: Boolean) {
        if (forceLoad || (screenStates.value?.isLoading != true)) {
            _screenStates.value = ScreenStates.LOADING
            viewModelScope.launch {
                try {
                    //perform some task--
                    delay(3000)
                    if (Random.nextInt(
                            from = 0,
                            until = 10
                        ) % 5 == 0
                    ) throw Exception("My custom exception")
                    ScreenStates.LOADED
                } catch (e: Exception) {
                    e.printStackTrace()
                    ScreenStates.ERROR
                }.let {
                    withContext(Dispatchers.Main) {
                        _screenStates.value = it
                    }
                }


            }
        } else {
            Log.d(TAG, "Already initialised")
        }
    }
}

enum class ScreenStates {
    LOADING, LOADED, ERROR;

    val isLoading: Boolean get() = (this == LOADING)

    companion object {
        fun getVisibility(isVisible: Boolean): Int {
            return if (isVisible) View.VISIBLE else View.GONE
        }
    }
}