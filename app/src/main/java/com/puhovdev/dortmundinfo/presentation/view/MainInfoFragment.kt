package com.puhovdev.dortmundinfo.presentation.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.puhovdev.dortmundinfo.databinding.FragmentMainInfoBinding
import com.puhovdev.dortmundinfo.presentation.viewModel.MainInfoFragmentViewModel
import com.squareup.picasso.Picasso

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadTeamInfoAndVenue()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    private fun loadTeamInfoAndVenue() = with(binding) {
        viewModel.teamInfoLiveData.observe(viewLifecycleOwner) {
            nameOfClub.text = it.name + " (${it.code})"
            nameOfCountry.text = it.country
            dateOfFounded.text = it.founded.toString()
            Picasso.get()
                .load(it.logo)
                .into(logoClub)
        }

        viewModel.venueInfoLivedata.observe(viewLifecycleOwner) {
            nameOfVenue.text = it.nameVenue
            sizeOfStadium.text = it.capacity.toString()
            nameOfCity.text = it.city
        }
    }


}