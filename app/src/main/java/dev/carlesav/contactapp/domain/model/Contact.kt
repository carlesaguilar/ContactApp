package dev.carlesav.contactapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val name: String,
    val image_url: String,
    val location: String,
    val phone: String,
    val email: String,
) : Parcelable
