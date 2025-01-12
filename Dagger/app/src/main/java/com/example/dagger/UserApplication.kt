package com.example.dagger

import android.app.Application

class UserApplication:Application() {

    lateinit var userRegistrationComponent: UserRegistrationComponent

    override fun onCreate() {
        super.onCreate()
        userRegistrationComponent = DaggerUserRegistrationComponent.builder().build()
    }
}