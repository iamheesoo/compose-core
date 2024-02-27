package com.example.composecore.dummy

val imageUrl = "https://picsum.photos/200/300"
val imageUrl2 = "https://image.brandi.me/cproduct/2020/02/05/13523740_1580910697_image1_L.jpg"
val imageList = mutableListOf<String>().apply {
    repeat(10) {
        this.add("https://picsum.photos/id/$it/200/300")
    }
}