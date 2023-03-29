package com.morladim.recordsandstatistics.common.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.morladim.recordsandstatistics.R
import com.morladim.recordsandstatistics.RecodesAndStatisticsApplication
import com.morladim.recordsandstatistics.common.db.base.BaseEntity
import java.util.*

/**
 * @author 5k5k
 * Created at 2023/3/27
 */
@Entity(tableName = "period")
data class PeriodEntity(
    @PrimaryKey(autoGenerate = true)
    override var id: Int? = null,
    @ColumnInfo(name = "create_at") override var createAt: Date? = Date(),
    @ColumnInfo(name = "update_at") override var updateAt: Date? = Date(),
    @ColumnInfo(name = "del") override var del: Boolean? = false,
    //-1为自定义（单位为天）；0为日常；1为周常；2为月常；3为年常
//    @ColumnInfo(name = "nature") val nature: Int,
    //周期的值，比如说3天的3，6周的6
    @ColumnInfo(name = "period_value") var periodValue: Int? = 1,
    //周期的值，比如说3天的天，6周的周，0为天，1为周；2为月；3为年
    @ColumnInfo(name = "period_unit") var periodUnit: Int? = 0,
//    @Ignore var displayName: String? = getName(periodValue, periodUnit),
) : BaseEntity() {
    val displayName: String
        get(): String {
            return getName(periodValue, periodUnit)
        }
}

fun getName(periodValue: Int?, periodUnit: Int?): String {
    val text = when (periodUnit) {
        0 -> {
            RecodesAndStatisticsApplication.appContext.getString(R.string.text_day)
        }
        1 -> {
            RecodesAndStatisticsApplication.appContext.getString(R.string.text_week)
        }
        2 -> {
            RecodesAndStatisticsApplication.appContext.getString(R.string.text_month)
        }
        3 -> {
            RecodesAndStatisticsApplication.appContext.getString(R.string.text_year)
        }
        else -> {
            RecodesAndStatisticsApplication.appContext.getString(R.string.text_day)
        }
    }
    return "$periodValue $text"
}