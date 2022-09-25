package com.example.recreationbase.presentaion.fooddetailpage

sealed class FoodDetailEvent{
    data class LoadInfo(val id : Int) : FoodDetailEvent()
}
