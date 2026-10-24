package com.example.visionapp.utils

import android.content.Context

class LanguageManager(context: Context) {

    private val prefs =
        context.getSharedPreferences(
            "language_prefs",
            Context.MODE_PRIVATE
        )

    fun salvarIdioma(
        idioma: String
    ) {
        prefs.edit()
            .putString("idioma", idioma)
            .apply()
    }

    fun obterIdioma(): String {

        return prefs.getString(
            "idioma",
            "Português"
        ) ?: "Português"
    }
}