package com.example.dagger2

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize: Int) {

    @Provides
    fun providesMemoryCard():MemoryCard{
        Log.i("MYTAG", "Size of memory is $memorySize")
        return MemoryCard()
    }
}