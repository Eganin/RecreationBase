package com.example.recreationbase.presentaion.mainpage.funchild

import com.example.recreationbase.data.remote.dto.funchild.FunChildDataDto

data class ChildFunState(
    val childFun : List<FunChildDataDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
