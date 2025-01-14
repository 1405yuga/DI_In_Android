package com.example.hilt

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor() {
    val TAG = this.javaClass.simpleName
    fun saveUser() {
        Log.d(TAG, "Save user")
    }
}