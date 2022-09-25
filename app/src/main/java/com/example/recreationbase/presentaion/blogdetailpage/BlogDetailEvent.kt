package com.example.recreationbase.presentaion.blogdetailpage

sealed class BlogDetailEvent{
    data class LoadInfo(val id : Int) : BlogDetailEvent()
}
