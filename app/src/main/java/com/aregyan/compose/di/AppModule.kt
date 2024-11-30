package com.aregyan.compose.di

import android.content.Context
import com.aregyan.compose.repository.ItemRepository
import com.aregyan.compose.util.DateJsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(DateJsonAdapter())
            .build()
    }

    @Provides
    @Singleton
    fun provideItemRepository(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): ItemRepository = ItemRepository(context, moshi)
}
