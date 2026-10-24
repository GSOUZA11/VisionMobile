package com.example.visionapp.utils

import android.content.Context

class AddressManager(context: Context) {

    private val prefs =
        context.getSharedPreferences(
            "address_prefs",
            Context.MODE_PRIVATE
        )

    fun salvarEndereco(endereco: String) {
        prefs.edit()
            .putString("endereco", endereco)
            .apply()
    }

    fun obterEndereco(): String {
        return prefs.getString(
            "endereco",
            ""
        ) ?: ""
    }
}