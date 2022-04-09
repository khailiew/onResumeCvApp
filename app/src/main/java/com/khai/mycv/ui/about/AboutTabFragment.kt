package com.khai.mycv.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.khai.mycv.IBackPressedHandler
import com.khai.mycv.R
import com.khai.mycv.databinding.FragmentAboutBinding

class AboutTabFragment :
    Fragment(), IBackPressedHandler {

    private val args: AboutTabFragmentArgs by navArgs()

    private lateinit var viewModel: AboutTabViewModel
    private lateinit var viewPager: ViewPager2

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[AboutTabViewModel::class.java]
        viewModel.aboutData = args.cvResponse.about

        postponeEnterTransition()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // transition animation
        val transitionInflater = TransitionInflater.from(requireContext())
        allowEnterTransitionOverlap = false
        enterTransition = transitionInflater.inflateTransition(R.transition.slide_right)
        returnTransition = transitionInflater.inflateTransition(R.transition.fade)


        binding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "${viewModel.aboutData[position].title}"
        }.attach()

        // start the postponed animation
        binding.viewPager.viewTreeObserver.addOnPreDrawListener(object :
            ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                binding.viewPager.viewTreeObserver.removeOnPreDrawListener(this)
                startPostponedEnterTransition()
                return true
            }
        })
    }

    private inner class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = viewModel.aboutData.size

        override fun createFragment(position: Int): Fragment {
            val aboutData = viewModel.aboutData[position]
            val aboutType = aboutData.type

            return if (aboutType == null)
                Fragment() // empty fragment for public data-less version
            else
                AboutFragmentFactory.getFragment(aboutType, aboutData)
        }
    }

    override fun onBackPressed(): IBackPressedHandler.Action {
        return if (viewPager.currentItem > 0) {
            viewPager.currentItem -= 1
            IBackPressedHandler.Action.SKIP_BACKPRESS
        } else
            IBackPressedHandler.Action.DO_BACKPRESS
    }

}