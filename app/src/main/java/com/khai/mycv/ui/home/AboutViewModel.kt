package com.khai.mycv.ui.home

import androidx.lifecycle.ViewModel
import com.khai.mycv.data.model.CvResponse
import com.khai.mycv.data.repository.DataRepository
import io.reactivex.rxjava3.core.Single

class AboutViewModel(private val dataRepository: DataRepository) : ViewModel() {

//  private val _text = MutableLiveData<String>().apply {
//    value = "This is home Fragment"
//  }
//  val text: LiveData<String> = _text


  fun fetchCvData(): Single<CvResponse> = dataRepository.fetchCvData()
}

