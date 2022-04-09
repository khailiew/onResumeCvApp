package com.khai.mycv.ui.component.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.khai.mycv.BuildConfig
import com.khai.mycv.data.model.CvResponse
import com.khai.mycv.databinding.FragmentAboutAppBinding
import com.khai.mycv.ui.binding.setVersionText
import com.khai.mycv.ui.common.parseFormatting

class AboutAppFragment : Fragment() {

    companion object {
        private const val DATA_KEY = "data"
        fun newInstance(data: CvResponse.About) =
            AboutAppFragment().apply {
                arguments = bundleOf(
                    DATA_KEY to data
                )
            }
    }

    private lateinit var _data: CvResponse.About

    private var _binding: FragmentAboutAppBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutAppBinding.inflate(inflater, container, false)

        _data = arguments?.getSerializable(DATA_KEY) as CvResponse.About

        setVersionText(binding.versionText, BuildConfig.VERSION_NAME)
        binding.repoLink.text = _data.projectLink
        binding.projectText.text = _data.projectDetails?.let { parseFormatting(it) }

        return binding.root
    }

}