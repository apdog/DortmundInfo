package com.puhovdev.dortmundinfo.domain

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import com.puhovdev.dortmundinfo.data.db.table.TeamInfoTable
import com.puhovdev.dortmundinfo.data.db.table.VenueInfoTable
import com.puhovdev.dortmundinfo.data.entities.teams.Team
import com.puhovdev.dortmundinfo.data.entities.teams.TeamResponse
import com.puhovdev.dortmundinfo.data.entities.teams.Venue
import com.puhovdev.dortmundinfo.data.remote.ApiConstants.TEAM_ID
import com.puhovdev.dortmundinfo.data.remote.FootballApiService
import com.puhovdev.dortmundinfo.data.repository.TeamInfoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(
    private val retrofitService: FootballApiService,
    private val teamInfoRepository: TeamInfoRepository
) {

    fun getTeamInfoFromApi() {
        retrofitService.getTeamById(TEAM_ID).enqueue(object : Callback<TeamResponse> {
            override fun onResponse(
                call: Call<TeamResponse>,
                response: Response<TeamResponse>
            ) {

                val teamResponse = response.body()?.response?.get(0)?.team
                if (teamResponse != null) {
                    val response = convertTeamInfoWithLiveData(teamResponse)
                    teamInfoRepository.putTeamIfoToDb(response)
                } else {
                    Log.d(TAG, "Получен нулевой список")
                }

                val venueResponse = response.body()?.response?.get(0)?.venue
                if (venueResponse != null) {
                    val response = convertVenueInfoWithLiveData(venueResponse)
                    teamInfoRepository.putVenueIfoToDb(response)
                } else {
                    Log.d(TAG, "Получен нулевой список")
                }


            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.d(TAG, "Ошибка при выполнении запроса на получение инфо о команде")
            }
        })
    }

    fun getTeamInfoFromDb(): LiveData<TeamInfoTable> = teamInfoRepository.getTeamInfoFromDb()

    fun getVenueInfoFromDb(): LiveData<VenueInfoTable> = teamInfoRepository.getVenueInfoFromDb()

    private fun convertTeamInfoWithLiveData(teamInfo: Team): TeamInfoTable {
        val result = teamInfo.let {
            TeamInfoTable(
                id = it.id,
                code = it.code,
                logo = it.logo,
                name = it.name,
                founded = it.founded,
                country = it.country
            )
        }
        return result
    }

    private fun convertVenueInfoWithLiveData(venueInfo: Venue): VenueInfoTable {
        val result = venueInfo.let {
            VenueInfoTable(
                id = it.id,
                address = it.address,
                capacity = it.capacity,
                city = it.city,
                imageVenue = it.image,
                nameVenue = it.name
            )
        }
        return result
    }
}