package dev.carlesav.contactapp.presentation.contacts_list

import dev.carlesav.contactapp.domain.model.Contact

data class ContactListState(
    val isLoading: Boolean = false,
    val items: List<Contact> = emptyList(),
    val error: String = "",
)
