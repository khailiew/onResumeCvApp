package com.khai.mycv.ui.component.education

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khai.mycv.data.repository.DataRepository
import com.khai.mycv.ui.common.BaseViewModel

class EducationViewModel(dataRepository: DataRepository) : BaseViewModel(dataRepository) {

  private val _text = MutableLiveData<String>().apply {
    value = "This is dashboard Fragment"
  }
  val text: LiveData<String> = _text
}