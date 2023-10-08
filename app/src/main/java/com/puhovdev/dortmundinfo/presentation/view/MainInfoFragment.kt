package com.puhovdev.dortmundinfo.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.puhovdev.dortmundinfo.databinding.FragmentMainInfoBinding
import com.puhovdev.dortmundinfo.presentation.viewModel.MainInfoFragmentViewModel

class MainInfoFragment : Fragment() {

    private var _binding: FragmentMainInfoBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MainInfoFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}