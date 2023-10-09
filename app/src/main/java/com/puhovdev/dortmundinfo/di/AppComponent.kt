package com.puhovdev.dortmundinfo.di

import com.puhovdev.dortmundinfo.di.modules.DatabaseModule
import com.puhovdev.dortmundinfo.di.modules.DomainModule
import com.puhovdev.dortmundinfo.di.modules.RemoteModule
import com.puhovdev.dortmundinfo.presentation.viewModel.MainInfoFragmentViewModel
import com.puhovdev.dortmundinfo.presentation.viewModel.PlayersViewModel
import com.puhovdev.dortmundinfo.presentation.viewModel.TournamentListFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {

    //методы для того, чтобы появилась возможность внедрять зависимости во фрагменты
    fun inject(mainInfoFragmentViewModel: MainInfoFragmentViewModel)

    fun inject(playersViewModel: PlayersViewModel)

    fun inject(tournamentListFragmentViewModel: TournamentListFragmentViewModel)


}