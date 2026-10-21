package com.example.visionapp.repository

import com.example.visionapp.api.RetrofitClient
import com.example.visionapp.model.Usuario
import retrofit2.Response

class PerfilRepository {

    suspend fun buscarPerfil(): Response<Usuario> {
        return RetrofitClient.apiService.buscarPerfil()
    }
}