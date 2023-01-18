package com.yaustal666.todos.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

data class FilterPreferences(val hideCompleted : Boolean)

@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")
    private val dataStore = context.dataStore

    private val HIDE_COMPLETED = booleanPreferencesKey("hide_completed")


    val prefFlow = dataStore.data.map { preferences ->
        val hideCompleted = preferences[HIDE_COMPLETED] ?: false

        FilterPreferences(hideCompleted)
    }

    suspend fun updateHideCompleted(hideCompleted: Boolean) {
        dataStore.edit { preferences ->
            preferences[HIDE_COMPLETED] = hideCompleted
        }
    }
}