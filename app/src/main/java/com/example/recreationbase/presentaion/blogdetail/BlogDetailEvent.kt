package com.example.recreationbase.presentaion.blogdetail

sealed class BlogDetailEvent{
    data class LoadInfo(val id : Int) : BlogDetailEvent()
}
