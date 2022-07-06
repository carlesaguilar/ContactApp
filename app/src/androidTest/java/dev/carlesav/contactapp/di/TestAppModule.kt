package dev.carlesav.contactapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import dev.carlesav.contactapp.data.di.RepositoryModule
import dev.carlesav.contactapp.domain.repository.ContactsRepository
import dev.carlesav.contactapp.repository.FakeRepositoryImpl
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
class TestAppModule {

    @Provides
    @Singleton
    fun provideRepositoryModule(): ContactsRepository = FakeRepositoryImpl()
}
