package dev.carlesav.contactapp.domain.use_case

import dev.carlesav.contactapp.core.Resource
import dev.carlesav.contactapp.domain.model.Contact
import dev.carlesav.contactapp.domain.repository.ContactsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(
    private val repository: ContactsRepository,
) {
    operator fun invoke(): Flow<Resource<List<Contact>>> = repository.getContacts()
}
