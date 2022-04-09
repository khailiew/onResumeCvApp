package com.khai.mycv.ui.component.about

import androidx.lifecycle.ViewModel
import com.khai.mycv.data.model.CvResponse

class AboutTabViewModel : ViewModel()  {

    lateinit var aboutData: List<CvResponse.About>

}