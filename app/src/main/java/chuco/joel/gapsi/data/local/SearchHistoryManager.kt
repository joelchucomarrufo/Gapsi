package chuco.joel.gapsi.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore("search_history")
private val SEARCH_HISTORY_KEY = stringSetPreferencesKey("search_history")

object SearchHistoryManager {

    suspend fun saveQuery(context: Context, query: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[SEARCH_HISTORY_KEY]?.toMutableSet() ?: mutableSetOf()
            current.add(query)
            preferences[SEARCH_HISTORY_KEY] = current
        }
    }

    suspend fun getHistory(context: Context): List<String> {
        val preferences = context.dataStore.data.first()
        return preferences[SEARCH_HISTORY_KEY]?.toList() ?: emptyList()
    }
}