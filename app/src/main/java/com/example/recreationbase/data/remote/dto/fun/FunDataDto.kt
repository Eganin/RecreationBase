package com.example.recreationbase.data.remote.dto.`fun`

import com.example.recreationbase.data.remote.dto.Image
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class FunDataDto(
    @SerialName("id") var id: Int? = null,
    @SerialName("image") var image: Image? = Image(),
    @SerialName("title") var title: String? = null,
    @SerialName("subtitle") var subtitle: String? = null
)
