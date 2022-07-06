package dev.carlesav.contactapp.repository

import dev.carlesav.contactapp.core.Resource
import dev.carlesav.contactapp.domain.model.Contact
import dev.carlesav.contactapp.domain.repository.ContactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepositoryImpl : ContactsRepository {
    override fun getContacts(): Flow<Resource<List<Contact>>> = flow {
        val contact1 = Contact(
            name = "Contact 1",
            image_url = "",
            location = "Barcelona",
            phone = "123",
            email = "demo@demo.com"
        )

        val contact2 = Contact(
            name = "Contact 2",
            image_url = "",
            location = "Madrid",
            phone = "123",
            email = "demo@demo.com"
        )

        emit(Resource.Success(listOf(contact1, contact2)))
    }
}
