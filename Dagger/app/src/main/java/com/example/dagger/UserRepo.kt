package com.example.dagger

import android.util.Log
import javax.inject.Inject

interface UserRepo {
    fun saveUser(email: String, password: String)
}

class SqlRepository @Inject constructor() : UserRepo {
    val TAG = this.javaClass.simpleName
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "save in SQL repo")
    }
}

class FirebaseRepository (): UserRepo {
    val TAG = this.javaClass.simpleName
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "save in Firebase repo")
    }
}
//Manuall---------
//class UserRepo {
//    val TAG = this.javaClass.simpleName
//    fun saveUser(email: String, password: String) {
//        Log.d(TAG, "uSER SAVED")
//    }
//}