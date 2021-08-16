package me.ismartin.umbatechnicaltest

import me.ismartin.umbatechnicaltest.presenter.MoviePresenter
import me.ismartin.umbatechnicaltest.presenter.MoviePresenterImpl
import me.ismartin.umbatechnicaltest.view.MoviesView
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Spy
import org.mockito.Mock
import org.mockito.Mockito

@RunWith(MockitoJUnitRunner::class)
class ExamplePresenterTest {

    @Mock
    private lateinit var view: MoviesView

    @Spy
    private lateinit var presenter: MoviePresenter

    fun setUp() {
        presenter = MoviePresenterImpl(view)
    }

    @Test
    fun `test_getPopularMovies_onPositiveResponse`() {
        /*Mockito.`when`(presenter.getPopularMovies())
            .thenReturn("asd")*/

        presenter.getPopularMovies()
    }

}