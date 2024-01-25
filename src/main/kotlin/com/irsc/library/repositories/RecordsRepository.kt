package com.irsc.library.repositories

import com.irsc.library.models.PatronModel
import com.irsc.library.models.RecordModel
import org.springframework.data.jpa.repository.JpaRepository

internal interface RecordsRepository : JpaRepository<RecordModel?, Long?>