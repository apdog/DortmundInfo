package com.puhovdev.dortmundinfo.data.entities.teams

data class TeamResponse(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<Response>,
    val results: Int
)