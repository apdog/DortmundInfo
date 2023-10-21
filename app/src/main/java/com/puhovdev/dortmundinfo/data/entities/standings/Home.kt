package com.puhovdev.dortmundinfo.data.entities.standings

data class Home(
    val draw: Int,
    val goals: Goals,
    val lose: Int,
    val played: Int,
    val win: Int
)