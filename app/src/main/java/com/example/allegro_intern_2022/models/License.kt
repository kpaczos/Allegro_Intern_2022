package com.example.allegro_intern_2022.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class License(
    val key: String,
    val name: String,
    val node_id: String,
    val spdx_id: String,
    //val url: Any
) :Parcelable