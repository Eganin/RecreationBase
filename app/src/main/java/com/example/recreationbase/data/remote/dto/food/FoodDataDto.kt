package com.example.recreationbase.data.remote.dto.food

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class FoodDataDto(
    @SerialName("success") var success: Boolean? = null,
    @SerialName("error") var error: String? = null,
    @SerialName("time") var time: String? = null,
    @SerialName("data") var data: List<FoodInfo> = emptyList()
)
