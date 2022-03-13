package com.khai.mycv.data.service

import com.khai.mycv.data.model.CvResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET

interface RemoteDataService {
    @GET("api/cv")
    fun getCvData(): Single<CvResponse>
}