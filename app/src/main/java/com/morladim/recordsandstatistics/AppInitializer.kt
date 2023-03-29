package com.morladim.recordsandstatistics

import android.content.Context
import androidx.startup.Initializer
import com.morladim.recordsandstatistics.common.AppRepository
import com.morladim.recordsandstatistics.common.LogUtils
import com.morladim.recordsandstatistics.common.db.base.DatabaseRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
class AppInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        LogUtils.init("===M##RecordsAndStatistics##")
        val appRepository = AppRepository(context.applicationContext)

        MainScope().launch {
            appRepository.appFirstRunFlow.collect {
                if (it) {
                    initDb(context)
                    appRepository.setAppHasInit()
                }
            }
        }
    }

    private suspend fun initDb(context: Context) {
        val databaseRepository = DatabaseRepository()
        databaseRepository.getDatabase(context.applicationContext, databaseRepository.dbExecutor()).init()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}