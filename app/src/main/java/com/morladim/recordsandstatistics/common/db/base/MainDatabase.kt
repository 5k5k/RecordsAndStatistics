package com.morladim.recordsandstatistics.common.db.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.morladim.recordsandstatistics.common.db.*

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
@Database(
    entities = [TaskEntity::class, TaskMonitorEntity::class, TaskProgressEntity::class, PeriodEntity::class, TaskPieceEntity::class],
    version = 1
)
@TypeConverters(DbConverters::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    abstract fun periodDao(): PeriodDao

    suspend fun init() {
        periodDao().init()
    }
}