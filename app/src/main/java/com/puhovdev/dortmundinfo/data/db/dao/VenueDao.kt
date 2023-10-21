package com.puhovdev.dortmundinfo.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puhovdev.dortmundinfo.data.db.table.VenueInfoTable

@Dao
interface VenueDao {

    @Query("SELECT * FROM venue_info")
    fun getCachedVenueInfo(): LiveData<VenueInfoTable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllVenueInfo(venueInfoTable: VenueInfoTable)

    @Query("DELETE FROM venue_info")
    fun deleteCachedVenueInfo()

}