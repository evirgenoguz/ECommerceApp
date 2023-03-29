package com.evirgenoguz.ecommerceapp.ui.fragments.shopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evirgenoguz.ecommerceapp.R
import com.evirgenoguz.ecommerceapp.databinding.FragmentHomeBinding
import com.evirgenoguz.ecommerceapp.ui.adapters.HomeViewPagerAdapter
import com.evirgenoguz.ecommerceapp.ui.fragments.categories.*
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragment = arrayListOf<Fragment>(
            MainCategoryFragment(),
            ChairFragment(),
            CupboardFragment(),
            TableFragment(),
            AccessoryFragment(),
            FurnitureFragment()
        )

        val viewPager2Adapter = HomeViewPagerAdapter(categoriesFragment, childFragmentManager, lifecycle)
        binding.vpHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tableLayout, binding.vpHome) { tab, position ->
            when(position) {
                0 -> tab.text = "Main"
                1 -> tab.text = "Chair"
                2 -> tab.text = "Cupboard"
                3 -> tab.text = "Table"
                4 -> tab.text = "Accessory"
                5 -> tab.text = "Furniture"
            }
        }.attach()
    }

}