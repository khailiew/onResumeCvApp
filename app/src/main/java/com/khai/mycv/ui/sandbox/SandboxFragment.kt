package com.khai.mycv.ui.sandbox

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.khai.mycv.databinding.FragmentSandboxBinding
import com.khai.mycv.ui.common.createFactory
import com.khai.mycv.ui.experience.SandboxViewModel


class SandboxFragment: Fragment() {
    private lateinit var viewModel: SandboxViewModel

    private var _binding: FragmentSandboxBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val factory = SandboxViewModel().createFactory()
        viewModel = ViewModelProvider(this, factory)[SandboxViewModel::class.java]

        _binding = FragmentSandboxBinding.inflate(inflater, container, false)

        binding.toolbar.background.alpha = 100

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        showSandboxToast()
        (activity as AppCompatActivity?)?.supportActionBar?.setShowHideAnimationEnabled(false)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)?.supportActionBar?.setShowHideAnimationEnabled(false)
        (activity as AppCompatActivity?)?.supportActionBar?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showSandboxToast() {
        Toast.makeText(this.context, "The Sandbox - where random features go to be POC'd", Toast.LENGTH_SHORT).show()
    }
}