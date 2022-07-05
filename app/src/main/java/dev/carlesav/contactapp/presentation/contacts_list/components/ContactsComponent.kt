package dev.carlesav.contactapp.presentation.contacts_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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

@Preview
@Composable
fun PreviewContactsComponent() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)) {

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

        ContactsComponent(
            contacts = listOf(contact1, contact2),
            onContactClick = {}
        )
    }
}