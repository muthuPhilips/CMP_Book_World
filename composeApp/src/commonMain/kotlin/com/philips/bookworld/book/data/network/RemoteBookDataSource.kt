package com.philips.bookworld.book.data.network

import com.philips.bookworld.book.data.dto.BookWorkDto
import com.philips.bookworld.book.data.dto.SearchResponseDto
import com.philips.bookworld.core.domain.DataError
import com.philips.bookworld.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}