package com.example.hilt

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class UserViewModel @Inject constructor(
    @Named("sql") private val userRepository: UserRepository
) : ViewModel() {

    val TAG = this.javaClass.simpleName
    fun loadSomeData() {
        Log.d(TAG, "loadSomeData from viewmodel called")
        userRepository.saveUser("viewModel@mail.com", "123")
    }
}