package org.d3if4009.bismillahmobprokelar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BuahProperty::class], version = 1, exportSchema = false)
abstract class BuahDatabase : RoomDatabase(){
    abstract val buahDao: BuahDao

    companion object {
        @Volatile
        private var INSTANCE: BuahDatabase? = null

        fun getInstance(context: Context): BuahDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BuahDatabase::class.java,
                        "buah_database"
                    )

                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}