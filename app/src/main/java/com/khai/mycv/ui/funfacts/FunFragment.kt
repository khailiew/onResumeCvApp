package com.khai.mycv.ui.funfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.khai.mycv.CvApplication
import com.khai.mycv.data.repository.DataRepository
import com.khai.mycv.databinding.FragmentFunBinding
import com.khai.mycv.ui.common.createFactory
import com.khai.mycv.ui.experience.FunViewModel

class FunFragment : Fragment() {
  private lateinit var dataRepository: DataRepository
  private lateinit var viewModel: FunViewModel

  private var _binding: FragmentFunBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    // initialise dependencies from appContainer
    val appContainer = (activity?.application as CvApplication).appContainer
    dataRepository = appContainer.dataRepository

    val factory = FunViewModel(dataRepository).createFactory()
    viewModel = ViewModelProvider(this, factory)[FunViewModel::class.java]

    _binding = FragmentFunBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}