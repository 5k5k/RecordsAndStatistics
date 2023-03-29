package com.morladim.recordsandstatistics.common

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "AppRepository")

/**
 * @author 5k5k
 * Created at 2023/3/28
 */

@Singleton
class AppRepository @Inject constructor(@ApplicationContext val context: Context) {

    private val appFirstRun = booleanPreferencesKey("app_first_run")

    val appFirstRunFlow: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[appFirstRun] ?: true
        }

    suspend fun setAppHasInit() {
        context.dataStore.edit { preferences ->
            preferences[appFirstRun] = false
        }
    }
}