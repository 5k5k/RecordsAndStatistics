package com.morladim.recordsandstatistics.common.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author 5k5k
 * Created at 2022/5/31
 */
@Entity(tableName = "task_monitor")
data class TaskMonitorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "create_at") val createAt: Date,
    @ColumnInfo(name = "update_at") val updateAt: Date,
    @ColumnInfo(name = "del") val del: Boolean,
    @ColumnInfo(name = "daily_task_id") val dailyTaskId: Int,
    //不是开始就是结束
    @ColumnInfo(name = "start") val start: Boolean,
    @ColumnInfo(name = "day") val day: String
)