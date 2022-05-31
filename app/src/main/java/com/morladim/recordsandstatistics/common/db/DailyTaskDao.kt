package com.morladim.recordsandstatistics.common.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
@Dao
interface DailyTaskDao {

//    @Query("SELECT * FROM view_history WHERE path = :path LIMIT 1")
//    fun findByPath(path: String): LiveData<ViewHistoryEntity?>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(viewHistoryEntity: ViewHistoryEntity)
}