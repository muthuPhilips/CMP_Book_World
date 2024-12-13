package com.philips.bookworld.book.presentation.book_detail

import com.philips.bookworld.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
