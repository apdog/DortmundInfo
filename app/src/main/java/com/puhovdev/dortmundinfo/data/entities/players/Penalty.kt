package com.puhovdev.dortmundinfo.data.entities.players

data class Penalty(
    val commited: Any,
    val missed: Int,
    val saved: Any,
    val scored: Int,
    val won: Int
)