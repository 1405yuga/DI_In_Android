package com.example.dagger

import dagger.Component

@Component
interface UserRegistrationComponent {

    fun getUserRegistrationInstance(): UserRegistrationService
}