package com.morladim.recordsandstatistics.common.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author 5k5k
 * Created at 2022/7/19
 */
@Entity(tableName = "task_progress")
data class TaskProgressEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "create_at") val createAt: Date,
    @ColumnInfo(name = "update_at") val updateAt: Date,
    @ColumnInfo(name = "del") val del: Boolean,
    @ColumnInfo(name = "current") val current: Int,
)
