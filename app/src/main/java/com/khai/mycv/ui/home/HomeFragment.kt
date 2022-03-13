package com.khai.mycv.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.transition.TransitionInflater
import com.khai.mycv.CvApplication
import com.khai.mycv.R
import com.khai.mycv.data.repository.DataRepository
import com.khai.mycv.databinding.FragmentHomeBinding
import com.khai.mycv.ui.common.createFactory
import com.khai.mycv.ui.common.parseFormatting

class HomeFragment : Fragment() {
    private lateinit var dataRepository: DataRepository
    private lateinit var viewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // initialise dependencies from appContainer
        val appContainer = (activity?.application as CvApplication).appContainer
        dataRepository = appContainer.dataRepository

        val factory = HomeViewModel(dataRepository).createFactory()
        viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // display text data
        viewModel.fetchCvData().subscribe { data ->
            val aboutData = data.sections.about
            binding.welcomeTitleText.text = aboutData.introTitle
            binding.welcomeBodyText.text = parseFormatting(aboutData.introBody)
        }

        // bind buttons
        binding.aboutAppButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_navigation_home_to_about_app)
        }
        binding.aboutMeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_navigation_home_to_about_me)
        }

        // transition animation
        val transInflater = TransitionInflater.from(requireContext())
        exitTransition = transInflater.inflateTransition(R.transition.fade)
        reenterTransition = transInflater.inflateTransition(R.transition.slide_left)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}