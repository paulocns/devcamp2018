package com.psato.devcamp.di.module

import com.psato.devcamp.data.repository.resource.ResourceRepository
import com.psato.devcamp.data.repository.resource.ResourceRepositoryImpl
import com.psato.devcamp.presentation.home.HomeFragmentViewModel
import com.psato.devcamp.presentation.search.QueryViewModelArc
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel{
        HomeFragmentViewModel()
    }

    viewModel{
        QueryViewModelArc(get())
    }
}