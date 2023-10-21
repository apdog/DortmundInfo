package com.puhovdev.dortmundinfo.di.modules

import android.content.Context
import com.puhovdev.dortmundinfo.data.remote.FootballApiService
import com.puhovdev.dortmundinfo.data.repository.TeamInfoRepository
import com.puhovdev.dortmundinfo.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideIterator(
        teamInfoRepository: TeamInfoRepository,
        footballApiService: FootballApiService,
    ) = Interactor(
        retrofitService = footballApiService,
        teamInfoRepository = teamInfoRepository
    )
}