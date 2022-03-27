package com.khai.mycv.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.khai.mycv.data.model.CvResponse
import com.khai.mycv.databinding.FragmentAboutMeBinding
import com.khai.mycv.ui.common.parseFormatting

class AboutMeFragment : Fragment() {

    companion object {
        private const val DATA_KEY = "data"
        fun newInstance(data: CvResponse.About) =
            AboutMeFragment().apply {
                arguments = bundleOf(DATA_KEY to data)
            }
    }

    private lateinit var _data: CvResponse.About

    private var _binding: FragmentAboutMeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutMeBinding.inflate(inflater, container, false)

        _data = arguments?.getSerializable(DATA_KEY) as CvResponse.About

        binding.profileText.text = _data.profile?.let { parseFormatting(it) }

        return binding.root
    }

}