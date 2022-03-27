package com.khai.mycv

import android.app.Application
import com.khai.mycv.data.adapter.AboutTypeAdapter
import com.khai.mycv.data.repository.DataRepository
import com.khai.mycv.data.source.MockClient
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class CvApplication: Application() {
    // Instance of AppContainer that will be used by all the Activities of the app
    val appContainer = AppContainer(this)
}

class AppContainer(application: Application) {
    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(MockClient(application)).build()
    private val moshi = Moshi.Builder().add(AboutTypeAdapter()).build()
    private val retrofit =
        Retrofit.Builder().client(okHttpClient).baseUrl("https://127.0.0.1") // does not matter what address, gets intercepted anyway
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    val dataRepository = DataRepository.invoke(retrofit)
}

