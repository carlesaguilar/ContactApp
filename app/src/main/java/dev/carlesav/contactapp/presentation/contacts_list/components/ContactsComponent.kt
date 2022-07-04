package dev.carlesav.contactapp.presentation.contacts_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.carlesav.contactapp.domain.model.Contact

@Composable
fun ContactsComponent(
    contacts: List<Contact>,
    onContactClick: (Contact) -> Unit,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {

        contacts.forEach { contact ->
            ContactCardComponent(
                contact = contact,
                onContactClick = { contact ->
                    onContactClick(contact)
                })
        }
    }
}
