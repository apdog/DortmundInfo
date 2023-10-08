package com.puhovdev.dortmundinfo

import android.app.Application
import com.puhovdev.dortmundinfo.di.AppComponent
import com.puhovdev.dortmundinfo.di.DaggerAppComponent
import com.puhovdev.dortmundinfo.di.modules.DatabaseModule
import com.puhovdev.dortmundinfo.di.modules.DomainModule
import com.puhovdev.dortmundinfo.di.modules.RemoteModule

class App : Application() {

    lateinit var dagger: AppComponent
    override fun onCreate() {
        super.onCreate()

        instance = this
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule())
            .build()
    }

    companion object {
        //Здесь статически хранится ссылка на экземпляр App
        lateinit var instance: App
            //Приватный сеттер, чтобы нельзя было в эту переменную присвоить что-либо другое
            private set
    }
}