package com.task.app.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.task.app.BuildConfig
import com.task.app.network.ApiResponseCallAdapterFactory
import com.task.app.network.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT = 5L
private const val BASE_URL = "https://raw.githubusercontent.com/"

val networkModule = module {

    single<ApiService>() {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(get<ApiResponseCallAdapterFactory>())
            .client(get())
            .build().create(ApiService::class.java)
    }

    single {
        OkHttpClient.Builder().apply {
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                addNetworkInterceptor(StethoInterceptor())
            }
        }.build()
    }

    single { ApiResponseCallAdapterFactory.create() }
}

