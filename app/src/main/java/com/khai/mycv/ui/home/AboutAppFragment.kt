package com.khai.mycv.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.khai.mycv.R
import com.khai.mycv.databinding.FragmentAboutAppBinding
import com.khai.mycv.ui.common.parseFormatting

class AboutAppFragment: Fragment() {

    private val args: AboutAppFragmentArgs by navArgs()

    private var _binding: FragmentAboutAppBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutAppBinding.inflate(inflater, container, false)

        val response = args.cvResponse
        binding.versionText.text = response.sections.about.projectVersion
        binding.projectText.text = parseFormatting(response.sections.about.projectDetails)

        // transition animation
        val transInflater = TransitionInflater.from(requireContext())
        enterTransition = transInflater.inflateTransition(R.transition.slide_right)
        returnTransition = transInflater.inflateTransition(R.transition.fade)


        return binding.root
    }

}