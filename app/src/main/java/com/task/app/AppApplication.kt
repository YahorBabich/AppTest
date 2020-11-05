package com.task.app

import android.app.Application
import com.task.app.di.networkModule
import com.task.app.di.repositoryModule
import com.task.app.di.dataModule
import com.task.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Koin
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                    dataModule,
                    networkModule
                )
            )
        }
    }
}