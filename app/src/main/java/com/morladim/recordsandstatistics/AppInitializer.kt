package com.morladim.recordsandstatistics

import android.content.Context
import androidx.startup.Initializer
import com.morladim.recordsandstatistics.common.AppRepository
import com.morladim.recordsandstatistics.common.LogUtils

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
class AppInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        LogUtils.init("===M##RecordsAndStatistics##")
        val appRepository = AppRepository(context.applicationContext)
        appRepository.checkFirstRun()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}