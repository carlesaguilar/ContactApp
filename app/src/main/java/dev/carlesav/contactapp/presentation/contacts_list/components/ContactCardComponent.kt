package dev.carlesav.contactapp.presentation.contacts_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.carlesav.contactapp.domain.model.Contact

@Composable
fun ContactCardComponent(contact: Contact) {
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(4.dp)) {

        Row(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {

            ContactImageComponent(
                imageUrl = contact.image_url,
                modifier = Modifier.clip(CircleShape)
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
