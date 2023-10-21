package com.puhovdev.dortmundinfo.data.db.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "team_info", indices = [Index(value = ["name"], unique = true)])
data class TeamInfoTable(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "logo") val logo: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "founded") val founded: Int,
    @ColumnInfo(name = "country") val country: String,
): Parcelable