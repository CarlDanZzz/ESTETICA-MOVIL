package com.example.estetica_movil.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://postdetermined-meteorically-phuong.ngrok-free.dev/api/"

    val api: CitaApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CitaApi::class.java)
    }
}
