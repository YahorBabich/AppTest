package com.task.app.di

import com.task.app.ui.details.DetailsViewModel
import com.task.app.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ListViewModel(get())
    }

    viewModel {
        DetailsViewModel(get())
    }
}