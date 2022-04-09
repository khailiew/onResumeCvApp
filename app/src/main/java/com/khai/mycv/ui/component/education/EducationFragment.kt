package com.khai.mycv.ui.component.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.khai.mycv.CvApplication
import com.khai.mycv.data.repository.DataRepository
import com.khai.mycv.databinding.FragmentEducationBinding
import com.khai.mycv.ui.common.createFactory

class EducationFragment : Fragment() {
  private lateinit var dataRepository: DataRepository
  private lateinit var viewModel: EducationViewModel

  private var _binding: FragmentEducationBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    // initialise dependencies from appContainer
    val appContainer = (activity?.application as CvApplication).appContainer
    dataRepository = appContainer.dataRepository

    val factory = EducationViewModel(dataRepository).createFactory()
    viewModel = ViewModelProvider(this, factory)[EducationViewModel::class.java]

    _binding = FragmentEducationBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}