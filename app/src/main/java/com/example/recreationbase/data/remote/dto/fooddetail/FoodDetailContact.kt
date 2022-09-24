package com.example.recreationbase.data.remote.dto.fooddetail

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class FoodDetailContact(
    @SerialName("phone") var phone: String? = null,
    @SerialName("email") var email: String? = null,
    @SerialName("vk") var vk: String? = null,
    @SerialName("ok") var ok: String? = null,
    @SerialName("youtube") var youtube: String? = null,
    @SerialName("telegram") var telegram: String? = null,
    @SerialName("whatsapp") var whatsapp: String? = null,
    @SerialName("twitter") var twitter: String? = null
)
