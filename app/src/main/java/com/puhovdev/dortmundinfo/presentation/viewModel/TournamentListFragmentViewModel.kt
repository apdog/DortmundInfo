package com.puhovdev.dortmundinfo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.puhovdev.dortmundinfo.App
import com.puhovdev.dortmundinfo.domain.Interactor
import javax.inject.Inject

class TournamentListFragmentViewModel : ViewModel() {

    //Инициализируем интератор
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
    }
}