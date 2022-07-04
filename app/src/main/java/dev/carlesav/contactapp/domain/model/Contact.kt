package dev.carlesav.contactapp.domain.model

data class Contact(
    val name: String,
    val image_url: String,
    val location: String,
    val phone: String,
    val email: String,
)
