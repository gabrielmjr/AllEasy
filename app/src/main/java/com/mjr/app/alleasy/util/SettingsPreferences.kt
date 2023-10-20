package com.mjr.app.alleasy.util

import android.content.Context
import android.content.SharedPreferences

class SettingsPreferences(private val context: Context) {

    private var sharedPreferences: SharedPreferences? = null

    init {
        initialize()
    }

    private fun initialize() {
        sharedPreferences =
            context.getSharedPreferences(SHARED_PREFERENCES_CONFIG, Context.MODE_PRIVATE)
    }

    var language: String?
        get() {
            val language = sharedPreferences!!.getString(LANGUAGE, "none")
            return if (language == "none") context.resources.configuration.locale.language else language
        }
        set(language) {
            sharedPreferences!!.edit().putString(LANGUAGE, language).apply()
        }

    companion object {
        const val SHARED_PREFERENCES_CONFIG = "app_config"
        const val THEME_NAME = "theme_mode"
        const val LANGUAGE = "lang"
        const val NIGHT_MODE = "night_mode"
        const val LIGHT_MODE = "dark_mode"
        const val PT = "portuguese"
        const val EN = "english"
        const val SET_BY_SYSTEM = "set_by_system"
        const val THEME_ID = "theme_id"
        const val LANG_ID = "lang_id"
    }
}