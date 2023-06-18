package com.d3if0114.MyKalkulatorCinta.network

import com.d3if0114.MyKalkulatorCinta.model.Pasangan
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface PasanganApi {
    @GET("pasangan.json")
    suspend fun getPasangan(): List<Pasangan>
}


object ServiceAPI {
    private const val BASE_URL_PASANGAN = "https://raw.githubusercontent.com/" +
            "AbdulMughnyRaihan/Assesment_Mobpro1/PasanganAPI/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofitPasangan = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL_PASANGAN)
        .build()

    //Retrofit Create


    val pasanganService: PasanganApi by lazy {
        retrofitPasangan.create(PasanganApi::class.java)
    }

    //Function


    fun getPasanganUrl(imageId: String): String {
        return "$BASE_URL_PASANGAN$imageId.jpg"
    }
}


enum class ApiStatus { LOADING, SUCCES,FAILED}
