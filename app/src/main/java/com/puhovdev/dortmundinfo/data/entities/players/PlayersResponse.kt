package com.puhovdev.dortmundinfo.data.entities.players

data class PlayersResponse(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<Response>,
    val results: Int
)