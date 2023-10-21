package com.puhovdev.dortmundinfo.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puhovdev.dortmundinfo.data.db.table.TeamInfoTable

@Dao
interface TeamDao {

    @Query("SELECT * FROM team_info")
    fun getCachedTeamInfo(): LiveData<TeamInfoTable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTeamInfo(teamInfoTable: TeamInfoTable)

    @Query("DELETE FROM team_info")
    fun deleteCachedTeamInfo()

}