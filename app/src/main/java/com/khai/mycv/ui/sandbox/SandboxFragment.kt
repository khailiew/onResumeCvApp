package com.khai.mycv.ui.sandbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.khai.mycv.databinding.FragmentSandboxBinding
import com.khai.mycv.ui.common.createFactory
import com.khai.mycv.ui.experience.SandboxViewModel

class SandboxFragment: Fragment() {
    private lateinit var viewModel: SandboxViewModel

    private var _binding: FragmentSandboxBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val factory = SandboxViewModel().createFactory()
        viewModel = ViewModelProvider(this, factory)[SandboxViewModel::class.java]

        _binding = FragmentSandboxBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}