package com.daecha.cryptodashboard.data

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val image: String,
    val current_price: Double
)

