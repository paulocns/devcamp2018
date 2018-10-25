package com.psato.devcamp.interactor.usecase.show

import com.psato.devcamp.data.entity.Rating
import com.psato.devcamp.data.entity.ShowResponse
import com.psato.devcamp.data.repository.show.ShowRepository
import com.psato.devcamp.interactor.usecase.UseCase

/**
 * Created by psato on 29/10/16.
 */

class SearchShows
constructor(private val showRepository: ShowRepository) :
        UseCase<List<ShowResponse>>() {

    lateinit var query: String

    override suspend fun executeOnBackground(): List<ShowResponse> {
        return showRepository.searchShow(query).map {
            runAsync {
                val rating: Rating = showRepository.showRating(it.show!!.ids!!.trakt!!)
                ShowResponse(it.show.title!!, rating.rating)
            }
        }.map {
            it.await()
        }
    }
}
