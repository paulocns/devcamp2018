package com.psato.devcamp.di.module

import com.psato.devcamp.data.repository.resource.ResourceRepository
import com.psato.devcamp.data.repository.resource.ResourceRepositoryImpl
import com.psato.devcamp.interactor.usecase.show.SearchShows
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val useCaseModule = module {
    factory {
        SearchShows(get())
    }
}