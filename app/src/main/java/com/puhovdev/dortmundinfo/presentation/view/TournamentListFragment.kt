package com.puhovdev.dortmundinfo.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.puhovdev.dortmundinfo.databinding.FragmentTournamentListBinding
import com.puhovdev.dortmundinfo.presentation.viewModel.TournamentListFragmentViewModel

class TournamentListFragment : Fragment() {

    private var _binding: FragmentTournamentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(TournamentListFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTournamentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}