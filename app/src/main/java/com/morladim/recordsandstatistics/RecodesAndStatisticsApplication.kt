package com.morladim.recordsandstatistics

import android.app.Application
import android.os.StrictMode
import dagger.hilt.android.HiltAndroidApp

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
@HiltAndroidApp
class RecodesAndStatisticsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setDebug()
        appContext = this
    }

    companion object {
        lateinit var appContext: RecodesAndStatisticsApplication
    }

    private fun setDebug() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .detectCustomSlowCalls()
//                    .penaltyDeath()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
//                    .penaltyDeath()
                    .build()
            )
        }
    }
}