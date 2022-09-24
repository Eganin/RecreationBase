package com.example.recreationbase.presentaion.mainpage.tours

import com.example.recreationbase.domain.model.TourData

data class TourState(
    val tours : List<TourData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
