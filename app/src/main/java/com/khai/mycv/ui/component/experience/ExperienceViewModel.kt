package com.khai.mycv.ui.component.experience

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khai.mycv.data.repository.DataRepository
import com.khai.mycv.ui.common.BaseViewModel

class ExperienceViewModel(dataRepository: DataRepository) : BaseViewModel(dataRepository) {

  private val _text = MutableLiveData<String>().apply {
    value = "This is notifications Fragment"
  }
  val text: LiveData<String> = _text
}