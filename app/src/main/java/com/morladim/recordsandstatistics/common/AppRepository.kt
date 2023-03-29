package com.morladim.recordsandstatistics.common

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.morladim.recordsandstatistics.common.db.base.DatabaseRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "AppRepository")

/**
 * @author 5k5k
 * Created at 2023/3/28
 */

@Singleton
class AppRepository @Inject constructor(@ApplicationContext val context: Context) {

    companion object {
        const val B_APP_FIRST_RUN = "b_app_first_run"
    }

    fun checkFirstRun() {
        MainScope().launch {
            val firstRun = getData(B_APP_FIRST_RUN, true).first()
            if (firstRun) {
                initDb(context)
                setData(B_APP_FIRST_RUN, false)
            }
        }
    }

    private suspend fun initDb(context: Context) {
        val databaseRepository = DatabaseRepository()
        databaseRepository.getDatabase(context.applicationContext, databaseRepository.dbExecutor()).init()
    }

    fun <T> getDataOnMainThread(key: String, default: T): T {
        return runBlocking {
            return@runBlocking getData(key, default).first()
        }
    }

    fun setDataOnMainThread(key: String, value: Any) {
        MainScope().launch {
            setData(key, value)
        }
    }

    suspend fun setData(key: String, value: Any) {
        when (value) {
            is Int -> {
                context.dataStore.edit {
                    it[intPreferencesKey(key)] = value
                }
            }
            is String -> {
                context.dataStore.edit {
                    it[stringPreferencesKey(key)] = value
                }
            }
            is Boolean -> {
                context.dataStore.edit {
                    it[booleanPreferencesKey(key)] = value
                }
            }
            is Float -> {
                context.dataStore.edit {
                    it[floatPreferencesKey(key)] = value
                }
            }
            is Double -> {
                context.dataStore.edit {
                    it[doublePreferencesKey(key)] = value
                }
            }
            else -> {
                throw RuntimeException("AppRepository set data wrong type!")
            }
        }
    }

    fun <T> getData(key: String, default: T): Flow<T> {
        return when (default) {
            is Int -> {
                context.dataStore.data.map {
                    it[intPreferencesKey(key)] ?: default
                }
            }
            is String -> {
                context.dataStore.data.map {
                    it[stringPreferencesKey(key)] ?: default
                }
            }
            is Boolean -> {
                context.dataStore.data.map {
                    it[booleanPreferencesKey(key)] ?: default
                }
            }
            is Float -> {
                context.dataStore.data.map {
                    it[floatPreferencesKey(key)] ?: default
                }
            }
            is String? -> {
                context.dataStore.data.map {
                    it[stringPreferencesKey(key)] ?: default
                }
            }
            is Double -> {
                context.dataStore.data.map {
                    it[doublePreferencesKey(key)] ?: default
                }
            }
            else -> {
                throw java.lang.RuntimeException("AppRepository get data error!")
            }
        } as Flow<T>
    }

}