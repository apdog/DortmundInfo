package com.puhovdev.dortmundinfo.data.entities.players

data class Response(
    val player: Player,
    val statistics: List<Statistic>
)