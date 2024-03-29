package com.puhovdev.dortmundinfo.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.puhovdev.dortmundinfo.App
import com.puhovdev.dortmundinfo.data.db.table.TeamInfoTable
import com.puhovdev.dortmundinfo.data.db.table.VenueInfoTable
import com.puhovdev.dortmundinfo.domain.Interactor
import javax.inject.Inject

class MainInfoFragmentViewModel : ViewModel() {

    val teamInfoLiveData: LiveData<TeamInfoTable>
    val venueInfoLivedata: LiveData<VenueInfoTable>

    //Инициализируем интератор
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        interactor.getTeamInfoFromApi()
        venueInfoLivedata = interactor.getVenueInfoFromDb()
        teamInfoLiveData = interactor.getTeamInfoFromDb()
    }




}