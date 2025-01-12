package com.example.dagger

import dagger.Component

@Component
interface UserRegistrationComponent {


    //    fun getUserRegistrationInstance(): UserRegistrationService
    fun emailServiceInstance(): EmailService

    fun injectToActivity(mainActivity: MainActivity)
}