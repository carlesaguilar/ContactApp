package dev.carlesav.contactapp.presentation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
            .clip(CircleShape)
            .then(modifier)
    )
}
