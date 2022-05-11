package com.example.cleanmvvm.presentation.di.movie

import com.example.cleanmvvm.presentation.artist.ArtistActivity
import com.example.cleanmvvm.presentation.movie.MovieActivity
import dagger.Subcomponent
import javax.inject.Inject

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }

}