package com.example.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
class UserModule {

    @Provides
    @Named("firebase")
    fun providesFirebaseRepository(): UserRepository {
        return FirebaseRepository()
    }

    @Provides
    @Named("sql")
    fun providesSQLRepository(sqlRepository: SQLRepository): UserRepository {
        return sqlRepository
    }

//    @Binds
//    @Named("sql")
//    abstract fun providesUserRepository(sqlRepository: SQLRepository): UserRepository
}