package com.example.recreationbase.data.remote.dto.fooddetail

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class FoodDetailDataDto(
    @SerialName("id") var id: Int? = null,
    @SerialName("title") var title: String? = null,
    @SerialName("subtitle") var subtitle: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("type") var type: String? = null,
    @SerialName("close") var close: Boolean? = null,
    @SerialName("icon") var icon: String? = null,
    @SerialName("color") var color: String? = null,
    @SerialName("address") var address: String? = null,
    @SerialName("lat") var lat: Double? = null,
    @SerialName("lon") var lon: Double? = null,
    @SerialName("contact") var contact: FoodDetailContactDto? = FoodDetailContactDto(),
    @SerialName("working_hours") var workingHours: List<FoodDetailWorkingHours> = emptyList(),
    @SerialName("images") var images: List<FoodDetailImagesDto> = emptyList()
)
