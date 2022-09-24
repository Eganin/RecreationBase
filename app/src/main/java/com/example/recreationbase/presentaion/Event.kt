package com.example.recreationbase.presentaion

sealed class Event{
    object LoadBlogs : Event()
    object LoadFoods : Event()
    object LoadRooms : Event()
    object LoadFun : Event()
    object LoadFunChild : Event()
    object LoadTours : Event()
    object LoadPlaces : Event()
}
