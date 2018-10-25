package com.psato.devcamp.di.module

import com.psato.devcamp.data.repository.show.ShowRepository
import com.psato.devcamp.data.repository.show.ShowRepositoryImpl
import org.koin.dsl.module.module

val repositoryModule = module {
    single<ShowRepository> {
        ShowRepositoryImpl(get())
    }
}
