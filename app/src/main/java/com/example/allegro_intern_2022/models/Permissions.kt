package com.example.allegro_intern_2022.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Permissions(
    val admin: Boolean,
    val maintain: Boolean,
    val pull: Boolean,
    val push: Boolean,
    val triage: Boolean
) :Parcelable