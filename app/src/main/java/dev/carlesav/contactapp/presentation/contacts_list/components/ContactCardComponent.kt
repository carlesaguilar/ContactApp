package dev.carlesav.contactapp.presentation.contacts_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.carlesav.contactapp.domain.model.Contact
import dev.carlesav.contactapp.presentation.components.ContactImageComponent

@Composable
fun ContactCardComponent(
    contact: Contact,
    onContactClick: (Contact) -> Unit,
) {
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(4.dp)
        .testTag("card-${contact.name}")
        .clickable { onContactClick(contact) }) {

        Row(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {

            ContactImageComponent(
                imageUrl = contact.image_url,
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
            )

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp)
            ) {

                Text(
                    text = contact.name,
                    style = MaterialTheme.typography.h5
                )
                Text(text = contact.location)
            }
        }
    }
}

@Preview
@Composable
fun PreviewContactCardComponent() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)) {

        val contact = Contact(
            name = "Name",
            image_url = "",
            location = "Barcelona",
            phone = "123",
            email = "demo@demo.com"
        )

        ContactCardComponent(
            contact = contact,
            onContactClick = {}
        )
    }
}
