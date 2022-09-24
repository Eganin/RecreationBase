package com.example.recreationbase.presentaion.mainpage.funs

import com.example.recreationbase.data.remote.dto.`fun`.FunDataDto

data class FunState(
    val funs : List<FunDataDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
