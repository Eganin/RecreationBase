package com.example.recreationbase.presentaion.fooddetail

sealed class FoodDetailEvent{
    data class LoadInfo(val id : Int) : FoodDetailEvent()
}
