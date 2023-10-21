package com.puhovdev.dortmundinfo.data.repository

import androidx.lifecycle.LiveData
import com.puhovdev.dortmundinfo.data.db.dao.TeamDao
import com.puhovdev.dortmundinfo.data.db.dao.VenueDao
import com.puhovdev.dortmundinfo.data.db.table.TeamInfoTable
import com.puhovdev.dortmundinfo.data.db.table.VenueInfoTable
import java.util.concurrent.Executors

class TeamInfoRepository(
    private val teamDao: TeamDao, private val venueDao: VenueDao
) {

    fun putTeamIfoToDb(teamInfo: TeamInfoTable) {
        Executors.newSingleThreadExecutor().execute {
            teamDao.insertAllTeamInfo(teamInfo)
        }
    }

    fun getTeamInfoFromDb(): LiveData<TeamInfoTable> = teamDao.getCachedTeamInfo()


    fun putVenueIfoToDb(venueInfo: VenueInfoTable) {
        Executors.newSingleThreadExecutor().execute {
            venueDao.insertAllVenueInfo(venueInfo)
        }
    }

    fun getVenueInfoFromDb():LiveData<VenueInfoTable> = venueDao.getCachedVenueInfo()

}