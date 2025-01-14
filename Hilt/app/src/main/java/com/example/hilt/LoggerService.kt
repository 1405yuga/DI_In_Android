package com.example.hilt

import android.util.Log
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@ActivityScoped
class LoggerService @Inject constructor() {
    val TAG = this.javaClass.simpleName

    fun log(message: String) {
        Log.d(TAG, message)
    }
}