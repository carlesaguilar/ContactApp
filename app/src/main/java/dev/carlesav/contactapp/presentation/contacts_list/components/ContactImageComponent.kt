package dev.carlesav.contactapp.presentation.contacts_list.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.carlesav.contactapp.R

@Composable
fun ContactImageComponent(
    imageUrl: String,
    modifier: Modifier,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        placeholder = painterResource(id = R.drawable.ic_baseline_person_24),
        modifier = Modifier
            .width(70.dp)
            .height(70.dp)
            .then(modifier)
    )
}
