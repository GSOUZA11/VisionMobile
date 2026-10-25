package com.example.visionapp.utils

import android.content.Context
import com.example.visionapp.model.PedidoReal
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PedidoManager(context: Context) {

    private val prefs =
        context.getSharedPreferences(
            "pedido_prefs",
            Context.MODE_PRIVATE
        )

    private val gson = Gson()

    fun salvarPedidos(
        pedidos: List<PedidoReal>
    ) {

        val json = gson.toJson(pedidos)

        prefs.edit()
            .putString("pedidos", json)
            .apply()
    }

    fun obterPedidos(): MutableList<PedidoReal> {

        val json =
            prefs.getString(
                "pedidos",
                null
            ) ?: return mutableListOf()

        val type =
            object : TypeToken<
                    MutableList<PedidoReal>
                    >() {}.type

        return gson.fromJson(
            json,
            type
        )
    }
}