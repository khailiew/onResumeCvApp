package com.khai.mycv.ui.about

import androidx.lifecycle.ViewModel
import com.khai.mycv.data.model.CvResponse

class AboutTabViewModel : ViewModel()  {

    lateinit var aboutData: List<CvResponse.About>

}