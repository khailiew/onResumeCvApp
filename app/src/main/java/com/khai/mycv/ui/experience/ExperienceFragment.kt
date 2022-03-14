package com.khai.mycv.ui.experience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.khai.mycv.CvApplication
import com.khai.mycv.data.repository.DataRepository
import com.khai.mycv.databinding.FragmentExperienceBinding
import com.khai.mycv.ui.common.createFactory

class ExperienceFragment : Fragment() {
  private lateinit var dataRepository: DataRepository
  private lateinit var viewModel: ExperienceViewModel

  private var _binding: FragmentExperienceBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    // initialise dependencies from appContainer
    val appContainer = (activity?.application as CvApplication).appContainer
    dataRepository = appContainer.dataRepository

    val factory = ExperienceViewModel(dataRepository).createFactory()
    viewModel = ViewModelProvider(this, factory)[ExperienceViewModel::class.java]

    _binding = FragmentExperienceBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}