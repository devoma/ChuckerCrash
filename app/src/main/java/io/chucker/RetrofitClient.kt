package io.chucker

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(context: Context) {
    val myApi: Api

    init {
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .build()
        val retrofit = Retrofit.Builder().baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        myApi = retrofit.create(Api::class.java)
    }

    companion object {
        fun getIntstance(context: Context): RetrofitClient {
            return RetrofitClient(context)
        }
    }
}