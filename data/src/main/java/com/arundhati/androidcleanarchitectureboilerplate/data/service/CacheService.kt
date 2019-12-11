package com.arundhati.androidcleanarchitectureboilerplate.data.service

import android.content.Context
import android.content.SharedPreferences
import com.arundhati.androidcleanarchitectureboilerplate.data.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CacheService @Inject constructor(appContext: Context) {

    private val prefName = BuildConfig.APPLICATION_ID
    private var prefs = appContext.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    fun clearPrefs(sync: Boolean = true) =
        prefs.edit().apply {
            clear()
            save(sync)
        }

    fun clearPrefsAsync() = clearPrefs(sync = false)

    fun removeKey(key: String, force: Boolean = false) = prefs.edit().remove(key).save(force)

    fun containsKey(key: String): Boolean? = prefs.contains(key)

    fun getString(key: String, defValue: String?): String? = prefs.getString(key, defValue)

    fun getString(key: String): String? = getString(key, null)

    fun setString(key: String, value: String) =
        prefs.edit().apply {
            putString(key, value)
            apply()
        }

    fun getInt(key: String, defValue: Int): Int? = prefs.getInt(key, defValue)

    fun getInt(key: String): Int? = getInt(key, 0)

    fun setInt(key: String, value: Int) =
        prefs.edit().apply {
            putInt(key, value)
            apply()
        }

    fun getLong(key: String, defValue: Long): Long? = prefs.getLong(key, defValue)

    fun getLong(key: String): Long? = getLong(key, 0L)

    fun setLong(key: String, value: Long) =
        prefs.edit().apply {
            putLong(key, value)
            apply()
        }

    fun getBoolean(key: String, defValue: Boolean): Boolean? = prefs.getBoolean(key, defValue)

    fun getBoolean(key: String): Boolean? = getBoolean(key, false)

    fun setBoolean(key: String, value: Boolean) =
        prefs.edit().apply {
            putBoolean(key, value)
            apply()
        }

    fun getFloat(key: String): Float? = prefs.getFloat(key, 0f)

    fun getFloat(key: String, defValue: Float): Float? = if (containsKey(key) == true) getFloat(key) else defValue

    fun setFloat(key: String, value: Float?) =
        prefs.edit().apply {
            putFloat(key, value!!)
            apply()
        }

    fun SharedPreferences.Editor.save(force: Boolean) {
        if (force) commit() else apply()
    }

}