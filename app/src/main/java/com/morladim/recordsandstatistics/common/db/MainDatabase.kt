package com.morladim.recordsandstatistics.common.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
@Database(
    entities = [DailyTaskEntity::class],
    version = 1
)

@TypeConverters(DbConverters::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun dailyTaskDao(): DailyTaskDao
}