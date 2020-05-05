package org.d3if4009.bismillahmobprokelar.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BuahDao {

    @Query("SELECT * FROM BuahProperty")
    fun getDataBuah(): LiveData<List<BuahProperty>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBuah(buah: List<BuahProperty>)
}
