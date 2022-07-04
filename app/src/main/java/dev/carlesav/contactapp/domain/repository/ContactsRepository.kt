package dev.carlesav.contactapp.domain.repository

import dev.carlesav.contactapp.core.Resource
import dev.carlesav.contactapp.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {
    fun getContacts(): Flow<Resource<List<Contact>>>
}
