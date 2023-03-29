package com.morladim.recordsandstatistics.common.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.morladim.recordsandstatistics.common.db.base.BaseDao

/**
 * @author 5k5k
 * Created at 2023/3/27
 */
@Dao
interface PeriodDao : BaseDao<PeriodEntity> {

    @Query("SELECT * FROM period ORDER BY id LIMIT (:limit) OFFSET (:offset) ")
    override suspend fun getByPage(limit: Int, offset: Int): Array<PeriodEntity>

    @Query("SELECT * FROM period WHERE del = 0 order by create_at")
    fun getAllPeriods(): LiveData<List<PeriodEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg periods: PeriodEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll1(vararg periods: PeriodEntity)

    suspend fun init() {
        val v1 = PeriodEntity(id = 1, periodUnit = 0)
        val v2 = PeriodEntity(id = 2, periodUnit = 1)
        val v3 = PeriodEntity(id = 3, periodUnit = 2)
        val v4 = PeriodEntity(id = 4, periodUnit = 3)
        insertAll(v1, v2, v3, v4)
    }
}