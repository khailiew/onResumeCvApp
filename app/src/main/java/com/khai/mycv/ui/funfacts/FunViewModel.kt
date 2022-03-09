package com.khai.mycv.ui.experience

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FunViewModel : ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is notifications Fragment"
  }
  val text: LiveData<String> = _text
}