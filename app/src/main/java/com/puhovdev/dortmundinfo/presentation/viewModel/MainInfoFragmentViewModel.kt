package com.puhovdev.dortmundinfo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.puhovdev.dortmundinfo.App
import com.puhovdev.dortmundinfo.domain.Iterator
import javax.inject.Inject

class MainInfoFragmentViewModel : ViewModel() {

    //Инициализируем интератор
    @Inject
    lateinit var iterator: Iterator

    init {
        App.instance.dagger.inject(this)
    }
}