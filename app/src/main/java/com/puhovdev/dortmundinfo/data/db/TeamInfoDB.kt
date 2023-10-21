package com.puhovdev.dortmundinfo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.puhovdev.dortmundinfo.data.db.dao.TeamDao
import com.puhovdev.dortmundinfo.data.db.dao.VenueDao
import com.puhovdev.dortmundinfo.data.db.table.TeamInfoTable
import com.puhovdev.dortmundinfo.data.db.table.VenueInfoTable
import com.puhovdev.dortmundinfo.data.remote.ApiConstants

@Database(entities = [TeamInfoTable::class, VenueInfoTable::class], version = ApiConstants.VERSION_TEAM_INFO_DB, exportSchema = false)
abstract class TeamInfoDb : RoomDatabase() {

    abstract fun teamDao(): TeamDao

    abstract fun venueDao(): VenueDao
}