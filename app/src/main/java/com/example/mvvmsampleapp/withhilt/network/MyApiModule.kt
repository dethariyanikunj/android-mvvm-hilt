package com.example.mvvmsampleapp.withhilt.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@InstallIn(SingletonComponent::class)
@Module
class MyApiModule {

    @Provides
    @Named("provide")
// Custom Qualifier: If we don't want to use @Named Qualifier
// Named annotation must required string and there are chances of typos
//    @ProvideQualifier
    fun provideMyApiInstance() : MyApi {
        return MyApi()
    }

    @Provides
    @Named("return")
    fun returnMyApiInstance() : MyApi {
        return MyApi()
    }
}