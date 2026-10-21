package com.example.visionapp.api

import com.example.visionapp.model.LoginRequest
import com.example.visionapp.model.LoginResponse
import com.example.visionapp.model.Oculos
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import com.example.visionapp.model.Usuario


interface ApiService {

    @POST("api/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET("api/oculos")
    suspend fun listarOculos(): Response<List<Oculos>>

    @GET("api/perfil")
    suspend fun buscarPerfil(): Response<Usuario>

}