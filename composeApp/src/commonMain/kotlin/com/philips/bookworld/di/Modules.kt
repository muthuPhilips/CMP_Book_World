package com.philips.bookworld.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.philips.bookworld.book.data.database.DatabaseFactory
import com.philips.bookworld.book.data.database.FavoriteBookDatabase
import com.philips.bookworld.book.data.network.KtorRemoteBookDataSource
import com.philips.bookworld.book.data.network.RemoteBookDataSource
import com.philips.bookworld.book.data.repository.DefaultBookRepository
import com.philips.bookworld.book.domain.BookRepository
import com.philips.bookworld.book.presentation.SelectedBookViewModel
import com.philips.bookworld.book.presentation.book_detail.BookDetailViewModel
import com.philips.bookworld.book.presentation.book_list.BookListViewModel
import com.philips.bookworld.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}