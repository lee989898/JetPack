package com.example.cleanmvvm.presentation.di.tvshow

import com.example.cleanmvvm.presentation.artist.ArtistActivity
import com.example.cleanmvvm.presentation.tvshow.TvShowActivity
import dagger.Subcomponent
import javax.inject.Inject

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }

}