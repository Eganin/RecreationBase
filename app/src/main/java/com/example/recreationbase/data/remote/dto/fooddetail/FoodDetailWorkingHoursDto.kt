package com.example.recreationbase.data.remote.dto.fooddetail

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class FoodDetailWorkingHours(
    @SerialName("days") var days: List<Int> = emptyList(),
    @SerialName("from") var from: String? = null,
    @SerialName("to") var to: String? = null
)