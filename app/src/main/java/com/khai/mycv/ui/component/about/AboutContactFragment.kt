package com.khai.mycv.ui.component.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.khai.mycv.data.model.CvResponse
import com.khai.mycv.databinding.FragmentAboutContactBinding

class AboutContactFragment : Fragment() {
    companion object {
        private const val DATA_KEY = "data"
        fun newInstance(data: CvResponse.About) =
            AboutContactFragment().apply {
                arguments = bundleOf(
                    DATA_KEY to data
                )
            }
    }
    private lateinit var _data: CvResponse.About

    private var _binding: FragmentAboutContactBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutContactBinding.inflate(inflater, container, false)

        _data = arguments?.getSerializable(DATA_KEY) as CvResponse.About

        binding.nameText.text = _data.name
        binding.pronounsText.text = _data.pronouns
        binding.addressText.text = _data.address
        binding.mobileText.text = _data.mobile
        binding.emailText.text = _data.email

        return binding.root
    }

}