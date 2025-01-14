package com.example.hilt

import javax.inject.Inject

class UserRepository @Inject constructor(val loggerService: LoggerService) {

    fun saveUser() {
        loggerService.log("User saved in DB ")
    }
}