package com.khai.mycv.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.khai.mycv.R
import com.khai.mycv.databinding.FragmentAboutAppBinding

class AboutAppFragment: Fragment() {
    private var _binding: FragmentAboutAppBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutAppBinding.inflate(inflater, container, false)

        // transition animation
        val transInflater = TransitionInflater.from(requireContext())
        enterTransition = transInflater.inflateTransition(R.transition.slide_right)

        return binding.root
    }

}