package com.example.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class UserModule {

//    @Provides
//    fun providesUserRepository(): UserRepository {
//        return FirebaseRepository()
//    }

    @Binds
    abstract fun providesUserRepository(sqlRepository: SQLRepository): UserRepository
}