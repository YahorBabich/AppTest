package com.task.app.di

import com.task.app.ui.details.DetailsRepository
import com.task.app.ui.details.DetailsRepositoryImpl
import com.task.app.ui.list.ListRepository
import com.task.app.ui.list.ListRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<ListRepository> {
        ListRepositoryImpl(get(), get())
    }

    single<DetailsRepository> {
        DetailsRepositoryImpl(get())
    }
}