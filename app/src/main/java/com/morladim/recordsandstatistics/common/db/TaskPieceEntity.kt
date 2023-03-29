package com.morladim.recordsandstatistics.common.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author 5k5k
 * Created at 2023/3/27
 */
@Entity(tableName = "task_piece")
data class TaskPieceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "create_at") val createAt: Date,
    @ColumnInfo(name = "update_at") val updateAt: Date,
    @ColumnInfo(name = "del") val del: Boolean,
    //任务表id
    @ColumnInfo(name = "task_id") val taskId: Long,
    //任务完成时间
    @ColumnInfo(name = "check_at") val checkAt: Date,
    //0完成；1未完成；2部分完成
    @ColumnInfo(name = "status") val status: Int,
//    描述信息
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "max_value") val maxValue: Int,
    @ColumnInfo(name = "done_value") val doneValue: Int,
    @ColumnInfo(name = "done_percent") val donePercent: Int,
)