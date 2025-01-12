package com.example.dagger

import dagger.Component

@Component(modules = [UserRepoModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {


    //    fun getUserRegistrationInstance(): UserRegistrationService
//    fun emailServiceInstance(): EmailService

    fun injectToActivity(mainActivity: MainActivity)
}