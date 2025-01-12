package com.example.dagger

import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepo: UserRepo,
    private val emailService: EmailService
) {

    fun register(email: String, password: String) {
        userRepo.saveUser(email, password)
        emailService.send(email, "something@gmail.com", "User registered!")
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