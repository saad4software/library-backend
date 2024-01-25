package com.irsc.library.repositories

import com.irsc.library.models.BookModel
import com.irsc.library.models.PatronModel
import org.springframework.data.jpa.repository.JpaRepository


internal interface PatronsRepository : JpaRepository<PatronModel?, Long?>