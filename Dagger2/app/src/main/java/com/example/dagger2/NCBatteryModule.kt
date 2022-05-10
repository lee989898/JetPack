package com.example.dagger2

import dagger.Binds
import dagger.Module

@Module
abstract class NCBatteryModule {

    @Binds
    abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery

}