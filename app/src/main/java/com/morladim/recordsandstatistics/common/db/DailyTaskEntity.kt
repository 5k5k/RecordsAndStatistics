package com.morladim.recordsandstatistics.common.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
@Entity(tableName = "daily_task")
data class DailyTaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    @ColumnInfo(name = "create_at") val createAt: Date,
    @ColumnInfo(name = "update_at") val updateAt: Date,
    @ColumnInfo(name = "current") val current: Int,
    @ColumnInfo(name = "total") val total: Int,
    //0为按时间（单位：分钟）；1为按次数
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "done_percent") val donePercent: Int,
)