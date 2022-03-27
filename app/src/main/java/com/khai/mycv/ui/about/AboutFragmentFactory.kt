package com.khai.mycv.ui.about

import androidx.fragment.app.Fragment
import com.khai.mycv.data.adapter.AboutType
import com.khai.mycv.data.model.CvResponse

class AboutFragmentFactory{
    companion object {
        fun getFragment(type: AboutType, data: CvResponse.About): Fragment {
            return when(type) {
                AboutType.ABOUT_ME -> AboutMeFragment.newInstance(data)
                AboutType.ABOUT_APP -> AboutAppFragment.newInstance(data)
                AboutType.CONTACT_DETAILS ->  AboutContactFragment.newInstance(data)
            }
        }

    }
}