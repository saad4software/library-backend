package com.irsc.library

import com.irsc.library.models.BookModel
import org.springframework.data.jpa.repository.JpaRepository


internal interface BooksRepository : JpaRepository<BookModel?, Long?>