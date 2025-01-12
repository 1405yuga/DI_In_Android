package com.example.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val daggerUserRegistrationComponent = DaggerUserRegistrationComponent.builder().build()

        val userRegistrationService = daggerUserRegistrationComponent.getUserRegistrationInstance()
        userRegistrationService.register("user@gmail.com", "1234")
// Manual injection----------------------
//
//        val userRepo = UserRepo()
//        val emailService = EmailService()
//        val userRegistrationService = UserRegistrationService(userRepo, emailService)
//        userRegistrationService.register("user@gmail.com", "1234")
    }

}