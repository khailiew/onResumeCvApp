package com.khai.mycv.data.repository

import com.khai.mycv.data.model.CvResponse
import com.khai.mycv.data.service.RemoteDataService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit


// Ref: https://stackoverflow.com/questions/55371861/android-repository-pattern-what-is-the-best-solution-to-create-an-object
object DataRepository {
    private lateinit var apiService: RemoteDataService

    operator fun invoke(retrofit: Retrofit): DataRepository {
        apiService = retrofit.create(RemoteDataService::class.java)
        return this
    }

    fun fetchCvData(): Single<CvResponse> = apiService.getCvData()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
}