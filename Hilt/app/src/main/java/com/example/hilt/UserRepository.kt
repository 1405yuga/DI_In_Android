package com.example.hilt

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"

interface UserRepository {
    fun saveUser(email: String, password: String)
}

class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User saved in SQL ")
    }

}

class FirebaseRepository : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User saved in Firebase ")
    }

}
//Constructor injection ----------------------------
//class UserRepository @Inject constructor(val loggerService: LoggerService) {
//
//    fun saveUser() {
//        loggerService.log("User saved in DB ")
//    }
//}