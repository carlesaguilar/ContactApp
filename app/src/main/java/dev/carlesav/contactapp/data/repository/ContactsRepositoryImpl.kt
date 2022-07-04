package dev.carlesav.contactapp.data.repository

import dev.carlesav.contactapp.core.Resource
import dev.carlesav.contactapp.domain.model.Contact
import dev.carlesav.contactapp.domain.repository.ContactsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactsRepositoryImpl() : ContactsRepository {
    override fun getContacts(): Flow<Resource<List<Contact>>> = flow {
        emit(Resource.Loading(isLoading = true))

        delay(3_000)
        val contacts = mutableListOf<Contact>()
        contacts.add(
            Contact(name = "Henry Walters",
                image_url = "https://randomuser.me/api/portraits/men/1.jpg",
                location = "London, England",
                phone = "(081)-454-0666",
                email = "henry.walters@example.com")
        )
        contacts.add(
            Contact(name = "Jack Watson",
                image_url = "https://randomuser.me/api/portraits/men/85.jpg",
                location = "New York, USA",
                phone = "(979)-014-3149",
                email = "jack.watson@example.com")
        )
        contacts.add(
            Contact(name = "Rafael Kennedy",
                image_url = "https://randomuser.me/api/portraits/men/88.jpg",
                location = "Berlin, Germany",
                phone = "(642)-883-6650",
                email = "rafael.kennedy@example.com")
        )
        contacts.add(
            Contact(name = "Audrey Rose",
                image_url = "https://randomuser.me/api/portraits/women/23.jpg",
                location = "Chicago, USA",
                phone = "(538)-202-5208",
                email = "audrey.rose@example.com")
        )
        contacts.add(
            Contact(name = "Ramona Williams",
                image_url = "https://randomuser.me/api/portraits/women/82.jpg",
                location = "Dublin, Ireland",
                phone = "(047)-143-8460",
                email = "ramona.williams@example.com")
        )
        contacts.add(
            Contact(name = "Julie Stewart",
                image_url = "https://randomuser.me/api/portraits/women/86.jpg",
                location = "Liverpool, England",
                phone = "(924)-242-1950",
                email = "julie.stewart@example.com")
        )
        contacts.add(
            Contact(name = "Ann Chen",
                image_url = "https://randomuser.me/api/portraits/women/5.jpg",
                location = "Pekin, China",
                phone = "(053)-531-8770",
                email = "ann.long@example.com")
        )
        contacts.add(
            Contact(name = "Ruben Curtis",
                image_url = "https://randomuser.me/api/portraits/men/87.jpg",
                location = "Miami, USA",
                phone = "(027)-966-1974",
                email = "ruben.curtis@example.com")
        )
        contacts.random()
        emit(Resource.Success(contacts))
    }
}
