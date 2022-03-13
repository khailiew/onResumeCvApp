package com.khai.mycv.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.khai.mycv.CvApplication
import com.khai.mycv.data.repository.DataRepository
import com.khai.mycv.databinding.FragmentHomeBinding
import com.khai.mycv.ui.common.createFactory

class AboutFragment : Fragment() {

    private lateinit var dataRepository: DataRepository
    private lateinit var viewModel: AboutViewModel

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // initialise dependencies from appContainer
        val appContainer = (activity?.application as CvApplication).appContainer
        dataRepository = appContainer.dataRepository

        val factory = AboutViewModel(dataRepository).createFactory()
        viewModel = ViewModelProvider(this, factory)[AboutViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView: TextView = binding.textHome
        viewModel.fetchCvData().subscribe { data -> textView.text = data.toString() }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}