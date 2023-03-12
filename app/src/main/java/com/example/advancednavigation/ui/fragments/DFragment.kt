package com.example.advancednavigation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.advancednavigation.R
import com.example.advancednavigation.databinding.FragmentDBinding
import com.example.advancednavigation.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DFragment : Fragment() {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupViewPager(){
        val fragmentList = arrayListOf<Fragment>(
            EFragment(), FFragment()
        )

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2){ tab, position ->
            tab.text = "TAB ${position + 1}"
        }.attach()
    }


}