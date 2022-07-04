package dev.carlesav.contactapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.carlesav.contactapp.data.repository.ContactsRepositoryImpl
import dev.carlesav.contactapp.domain.repository.ContactsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideContactsRepository(): ContactsRepository = ContactsRepositoryImpl()
}
