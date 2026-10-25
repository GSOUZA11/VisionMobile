package com.example.visionapp.utils

import android.content.Context

class ProfileImageManager(
    context: Context
) {

    private val prefs =
        context.getSharedPreferences(
            "profile_image",
            Context.MODE_PRIVATE
        )

    fun salvarImagem(uri: String) {

        prefs.edit()
            .putString(
                "image_uri",
                uri
            )
            .apply()
    }

    fun obterImagem(): String {

        return prefs.getString(
            "image_uri",
            null
        ) ?: ""
    }
}