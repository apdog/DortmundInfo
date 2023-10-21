package com.puhovdev.dortmundinfo.data.entities.standings

data class StandingsResponse(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<Response>,
    val results: Int
)