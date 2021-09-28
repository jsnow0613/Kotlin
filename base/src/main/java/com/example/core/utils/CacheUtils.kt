package com.example.core.utils


import com.example.core.BaseApplication
import android.annotation.SuppressLint
import com.example.core.R
import android.content.Context

object CacheUtils {
    @SuppressLint("StaticFieldLeak")
    private val context: Context = BaseApplication.Companion.currentApplication()
    private val SP =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) {
        SP.edit().putString(key, value).apply()
    }

    operator fun get(key: String?): String? {
        return SP.getString(key, null)
    }
}