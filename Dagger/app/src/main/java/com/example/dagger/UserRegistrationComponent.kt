package com.example.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserRepoModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {


    //    fun getUserRegistrationInstance(): UserRegistrationService
//    fun emailServiceInstance(): EmailService

    fun injectToActivity(mainActivity: MainActivity)
}