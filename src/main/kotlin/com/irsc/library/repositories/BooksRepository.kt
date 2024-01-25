package com.irsc.library.repositories

import com.irsc.library.models.BookModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository


internal interface BooksRepository : CrudRepository<BookModel?, Long?>