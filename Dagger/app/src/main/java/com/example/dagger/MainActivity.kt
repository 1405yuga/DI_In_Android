package com.example.dagger

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //    Field injection
    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var emailService: EmailService

    @Inject
    lateinit var emailService1: EmailService

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val daggerUserRegistrationComponent = DaggerUserRegistrationComponent.builder().build()
        val component = (application as UserApplication).userRegistrationComponent
        component.injectToActivity(this)

        userRegistrationService.register("user@gmail.com", "1234")

        Log.d(TAG, "emailService :${emailService.hashCode()}")
        Log.d(TAG, "emailService1 :${emailService1.hashCode()}")

//Injection using individual function --------------------------
//        val userRegistrationService = daggerUserRegistrationComponent.getUserRegistrationInstance()
//        userRegistrationService.register("user@gmail.com", "1234")
//        daggerUserRegistrationComponent.emailServiceInstance()
// Manual injection----------------------
//
//        val userRepo = UserRepo()
//        val emailService = EmailService()
//        val userRegistrationService = UserRegistrationService(userRepo, emailService)
//        userRegistrationService.register("user@gmail.com", "1234")
    }

}