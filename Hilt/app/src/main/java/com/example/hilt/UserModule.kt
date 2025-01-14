package com.example.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class UserModule {

    @Provides
    fun providesUserRepository(): UserRepository {
        return FirebaseRepository()
    }
}