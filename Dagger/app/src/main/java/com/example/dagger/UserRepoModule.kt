package com.example.dagger

import dagger.Binds
import dagger.Module

@Module
abstract class UserRepoModule {

//    @Provides
//    fun  getFirebaseRepo():UserRepo{
//        //write custom initialisation code
//        return FirebaseRepository()
//    }

    @Binds
    abstract fun getSqlRepo(sqlRepository: SqlRepository): UserRepo
}