package com.example.recreationbase.data.remote.dto.fooddetail

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class FoodDetailImagesDto(
    @SerialName("orig") var orig: String? = null,
    @SerialName("prev") var prev: String? = null
)
