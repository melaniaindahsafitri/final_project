package org.d3if4009.bismillahmobprokelar.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "BuahProperty")
data class BuahProperty(
    @PrimaryKey
    val nama_bindo: String,
    val nama_bing: String,
    val warna: String,
    val manfaat: String,
    val imgSrcUrl: String
) : Parcelable