package com.example.visionapp.utils

import android.content.Context

class ThemeManager(context: Context) {

    private val prefs =
        context.getSharedPreferences(
            "theme_prefs",
            Context.MODE_PRIVATE
        )

    fun salvarTemaEscuro(
        ativo: Boolean
    ) {

        prefs.edit()
            .putBoolean(
                "dark_theme",
                ativo
            )
            .apply()
    }

    fun obterTemaEscuro(): Boolean {

        return prefs.getBoolean(
            "dark_theme",
            false
        )
    }
}