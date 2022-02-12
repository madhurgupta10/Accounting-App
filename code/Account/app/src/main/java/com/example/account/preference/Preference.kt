package com.example.account.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Preference(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    suspend fun updateNightMode(isNightMode: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[UI_MODE_KEY] = isNightMode
        }
    }

    suspend fun updateInitData(isDataLoaded: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[INIT_DATA_KEY] = isDataLoaded
        }
    }

    val uiMode: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            val uiMode = preferences[UI_MODE_KEY] ?: false
            uiMode
        }

    val initData: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            val initData = preferences[INIT_DATA_KEY] ?: false
            initData
        }

    companion object {
        private val UI_MODE_KEY = booleanPreferencesKey("ui_mode")
        private val INIT_DATA_KEY = booleanPreferencesKey("init_data")
    }
}