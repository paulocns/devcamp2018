package com.psato.devcamp.interactor.usecase.show

import com.psato.devcamp.data.entity.*
import com.psato.devcamp.data.repository.show.ShowRepository
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito

class SearchShowsTest {

    lateinit var usecase: UsecaseTest

    lateinit var showRepositoryMock: ShowRepository
    open class UsecaseTest constructor(showRepository: ShowRepository): SearchShows(showRepository){
        public override suspend fun executeOnBackground(): List<ShowResponse> {
            return super.executeOnBackground()
        }
    }

    @Before
    fun setUp() {
        showRepositoryMock = Mockito.mock(ShowRepository::class.java)
        usecase = Mockito.spy(UsecaseTest(showRepositoryMock))
    }

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(usecase, showRepositoryMock)
    }


    @Test
    fun executeOnBackground_query() {
        runBlocking {
            //Arrange
            val query = "game"
            usecase.query = query
            val resultList = arrayListOf<ShowInfo>()
            val showInfo = ShowInfo()
            val ids = ShowIds()
            val id = "id"
            val show = Show()
            val title = "title"
            val ratingValue = 10.0
            show.title = title
            ids.trakt = id
            show.ids = ids
            showInfo.show = show
            val rating = Rating()
            rating.rating = ratingValue
            resultList.add(showInfo)
            Mockito.doReturn(resultList).`when`(showRepositoryMock).searchShow(anyString())
            Mockito.doReturn(rating).`when`(showRepositoryMock).showRating(anyString())
            //Act
            val result = usecase.executeOnBackground()
            //Assert
            Mockito.verify(usecase).executeOnBackground()
            Mockito.verify(showRepositoryMock).searchShow(query)
            Mockito.verify(showRepositoryMock).showRating(id)
            assertEquals(1, result.size)
            assertEquals(title, result[0].name)
            assertEquals(ratingValue, result[0].rating)
        }
    }
}