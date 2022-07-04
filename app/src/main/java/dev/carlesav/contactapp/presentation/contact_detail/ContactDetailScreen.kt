package dev.carlesav.contactapp.presentation.contact_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.carlesav.contactapp.domain.model.Contact

@Destination
@Composable
fun ContactDetailScreen(
    navigator: DestinationsNavigator,
    contact: Contact,
) {
    Text(text = "Contact detail screen: " + contact.name)
}
