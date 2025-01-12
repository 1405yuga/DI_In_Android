package com.example.dagger

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule {

    @Provides
    @Named("message")
    fun getMessageService(): NotificationService {
        return MessageService()
    }

    @Provides
    @Named("email")
    fun getEmailService(emailService: EmailService): NotificationService {
        return emailService
    }
}