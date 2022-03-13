package com.khai.mycv.ui.common

import androidx.lifecycle.ViewModel
import com.khai.mycv.data.model.CvResponse
import com.khai.mycv.data.repository.DataRepository
import io.reactivex.rxjava3.core.Single

abstract class BaseViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun fetchCvData(): Single<CvResponse> = dataRepository.fetchCvData()
}