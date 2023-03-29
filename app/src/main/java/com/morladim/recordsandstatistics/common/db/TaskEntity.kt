package com.morladim.recordsandstatistics.common.db


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "create_at", defaultValue = "CURRENT_TIMESTAMP") val createAt: Date,
    @ColumnInfo(name = "update_at", defaultValue = "CURRENT_TIMESTAMP") val updateAt: Date,
    @ColumnInfo(name = "del", defaultValue = "0") val del: Boolean,
//    @ColumnInfo(name = "current") val current: Int,
//    @ColumnInfo(name = "total") val total: Int,
//    //0为按时间（单位：分钟）；1为按次数
//    @ColumnInfo(name = "type") val type: Int,
//    @ColumnInfo(name = "done_percent") val donePercent: Int,
    //0初始化；1进行中；2完成
    @ColumnInfo(name = "status") val status: Int,
    @ColumnInfo(name = "order") val order: Int,
    @ColumnInfo(name = "enable", defaultValue = "1") val enable: Boolean,
    //默认-1为无限
    @ColumnInfo(name = "times", defaultValue = "-1") val times: Int,
    //周期表id
    @ColumnInfo(name = "period_id") val periodId: Long,
//    描述信息
    @ColumnInfo(name = "description") val description: String,
    //任务开始时间
    @ColumnInfo(name = "begin_at") val beginDate: Date,
)