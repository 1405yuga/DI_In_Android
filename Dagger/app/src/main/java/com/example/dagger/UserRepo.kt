package com.example.dagger

import android.util.Log
import javax.inject.Inject

class UserRepo @Inject constructor() {
    val TAG = this.javaClass.simpleName
    fun saveUser(email: String, password: String) {
        Log.d(TAG, "uSER SAVED")
    }
}
//Manuall---------
//class UserRepo {
//    val TAG = this.javaClass.simpleName
//    fun saveUser(email: String, password: String) {
//        Log.d(TAG, "uSER SAVED")
//    }
//}