package com.irsc.library.controllers

import com.irsc.library.models.RecordModel
import com.irsc.library.repositories.BooksRepository
import com.irsc.library.repositories.PatronsRepository
import com.irsc.library.repositories.RecordsRepository
import com.irsc.library.util.NotFoundException
import org.springframework.data.jpa.domain.Specification
import org.springframework.web.bind.annotation.*

@RestController
internal class RecordsController(
    var repository: RecordsRepository,
    var patronsRepository: PatronsRepository,
    var booksRepository: BooksRepository,
    ) {

    @GetMapping("/records")
    fun all(): List<RecordModel?> {
        return repository.findAll()
    }

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    fun newItem(
        @RequestBody newItem:RecordModel?,
        @PathVariable bookId: Long,
        @PathVariable patronId: Long
    ): RecordModel {
        val book = booksRepository.findById(bookId)
            .orElseThrow { NotFoundException("book",bookId) }
        val patron = patronsRepository.findById(patronId)
            .orElseThrow { NotFoundException("patron",patronId) }

        val item = RecordModel()
//        item.book = book
        item.patron = patron
        return repository.save(item)
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    fun editItem(
        @RequestBody newItem:RecordModel?,
        @PathVariable bookId: Long,
        @PathVariable patronId: Long,
    ): RecordModel {
        val book = booksRepository.findById(bookId)
            .orElseThrow { NotFoundException("book",bookId) }
        val patron = patronsRepository.findById(patronId)
            .orElseThrow { NotFoundException("patron",patronId) }

//        val results: List<RecordModel> = repository.findAll(Specification.where(spec1).and(spec2))
        val item = RecordModel()
//        item.book = book
        item.patron = patron
        return repository.save(item)
    }

}