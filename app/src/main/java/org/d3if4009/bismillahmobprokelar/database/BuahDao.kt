package org.d3if4009.bismillahmobprokelar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface BuahDao {

    @Query("SELECT * FROM BuahProperty")
    fun getDataBuah(): LiveData<List<BuahProperty>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBuah(buah: List<BuahProperty>)
}