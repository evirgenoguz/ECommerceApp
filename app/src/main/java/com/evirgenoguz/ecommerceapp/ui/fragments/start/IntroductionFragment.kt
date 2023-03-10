package com.evirgenoguz.ecommerceapp.ui.fragments.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evirgenoguz.ecommerceapp.R
import com.evirgenoguz.ecommerceapp.databinding.FragmentAccountOptionsBinding
import com.evirgenoguz.ecommerceapp.databinding.FragmentIntroductionBinding


class IntroductionFragment : Fragment() {

    private var _binding: FragmentIntroductionBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIntroductionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}