package com.morladim.recordsandstatistics.manage.period

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.morladim.recordsandstatistics.common.db.PeriodDao
import com.morladim.recordsandstatistics.common.db.PeriodEntity
import com.morladim.recordsandstatistics.common.db.base.DatabaseRepository
import com.morladim.recordsandstatistics.common.db.base.MainDatabase
import com.morladim.recordsandstatistics.common.ui.DefaultPagingSource
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author 5k5k
 * Created at 2023/3/27
 */
@Singleton
class PeriodManageRepository @Inject constructor(private val pagingSource: DefaultPagingSource<PeriodEntity, PeriodDao>) {

    @Inject
    lateinit var periodDao: PeriodDao

    @Inject
    lateinit var db: MainDatabase

    @DatabaseRepository.DbExecutor
    @Inject
    lateinit var executor: Executor

//    suspend fun init() {
//        val v1 = PeriodEntity(id = 1, nature = 0)
//        val v2 = PeriodEntity(id = 2, nature = 1)
//        val v3 = PeriodEntity(id = 3, nature = 2)
//        periodDao.insertAll(v1, v2, v3)
//    }

    fun getAllPeriods(): LiveData<List<PeriodEntity>> {
        return periodDao.getAllPeriods()
    }

    fun getPagingData(): Flow<PagingData<PeriodEntity>> {
        return Pager(
            config = PagingConfig(1),
            pagingSourceFactory = { pagingSource }
        ).flow
    }

//    fun init1() {
//        executor.execute {
//            db.runInTransaction {
////                val v1 = PeriodEntity(1, Date(), Date(), false, nature = 0,0, 0)
////                val v2 = PeriodEntity(null, Date(), Date(), null, nature = 1, null, null)
//
//                periodDao.insertAll1(v2)
//            }
//        }
//    }
}