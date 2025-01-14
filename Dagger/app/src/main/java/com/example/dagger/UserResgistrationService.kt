package com.example.dagger

import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService @Inject constructor(
    private val userRepo: UserRepo,
    @Named("message") private val notificationService: NotificationService
) {

    fun register(email: String, password: String) {
        userRepo.saveUser(email, password)
        notificationService.send(email, "something@gmail.com", "User registered!")
    }
}

///Manual-----------
//class UserRegistrationService(
//    private val userRepo: UserRepo,
//    private val emailService: EmailService
//) {
//
//    fun register(email: String, password: String) {
//        userRepo.saveUser(email, password)
//        emailService.send(email, "something@gmail.com", "User registered!")
//    }
//}