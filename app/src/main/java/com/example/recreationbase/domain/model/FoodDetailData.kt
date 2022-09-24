package com.example.recreationbase.domain.model

import com.example.recreationbase.data.remote.dto.fooddetail.FoodDetailImagesDto

data class FoodDetailData(
    var id: Int? = null,
    var title: String? = null,
    var subtitle: String? = null,
    var description: String? = null,
    var address: String? = null,
    var phone: String? = null,
    var close: Boolean? = null,
    var workingHours : List<Pair<String,String>>?=null,
    var images: List<FoodDetailImagesDto> = emptyList()
)
