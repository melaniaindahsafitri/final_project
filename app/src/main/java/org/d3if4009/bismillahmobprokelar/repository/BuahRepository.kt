package org.d3if4009.bismillahmobprokelar.repository

import org.d3if4009.bismillahmobprokelar.database.BuahDao

class BuahRepository private constructor(private val buahDao: BuahDao){

    fun getDataBuah() = buahDao.getDataBuah()

    companion object {
        @Volatile
        private var instance: BuahRepository? = null

        fun getInstance(buahDao: BuahDao) =
            instance ?: synchronized(this){
                instance
                    ?: BuahRepository(buahDao)
                        .also { instance = it }
            }
    }
}