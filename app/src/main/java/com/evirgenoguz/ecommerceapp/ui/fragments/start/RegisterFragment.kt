package com.evirgenoguz.ecommerceapp.ui.fragments.start

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.evirgenoguz.ecommerceapp.R
import com.evirgenoguz.ecommerceapp.data.User
import com.evirgenoguz.ecommerceapp.databinding.FragmentAccountOptionsBinding
import com.evirgenoguz.ecommerceapp.databinding.FragmentRegisterBinding
import com.evirgenoguz.ecommerceapp.util.Resource
import com.evirgenoguz.ecommerceapp.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private val TAG = "RegisterFragment"

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnRegister.setOnClickListener {
                val user = User(
                    etFirstName.text.toString().trim(),
                    etLastName.text.toString().trim(),
                    etEmail.text.toString().trim(),
                )
                val password = etPassword.text.toString().trim()
                viewModel.createAccountWithEmailAndPassword(user, password)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.register.collect{
                when(it) {
                    is Resource.Loading -> {
                        binding.btnRegister.startAnimation()
                    }
                    is Resource.Success -> {
                        Log.d("test", it.data.toString())
                        binding.btnRegister.revertAnimation()
                    }
                    is Resource.Error -> {
                        Log.e(TAG, it.message.toString())
                        binding.btnRegister.revertAnimation()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}