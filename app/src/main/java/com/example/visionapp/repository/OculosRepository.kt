package com.example.visionapp.repository

import com.example.visionapp.api.RetrofitClient

class OculosRepository {

    suspend fun listarOculos() =
        RetrofitClient.apiService.listarOculos()

}