package com.puhovdev.dortmundinfo.data.db.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "venue_info", indices = [Index(value = ["name"], unique = true)])
data class VenueInfoTable(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "capacity") val capacity: Int,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "imageVenue") val imageVenue: String,
    @ColumnInfo(name = "name") val nameVenue: String
) : Parcelable