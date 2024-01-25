package com.irsc.library.controllers

import com.irsc.library.BooksRepository
import com.irsc.library.models.BookModel
import com.irsc.library.util.BookNotFoundException
import org.springframework.web.bind.annotation.*


@RestController
internal class EmployeeController(repository: BooksRepository) {
    private val repository: BooksRepository

    init {
        this.repository = repository
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/books")
    fun all(): List<BookModel?> {
        return repository.findAll()
    }

    // end::get-aggregate-root[]
    @PostMapping("/books")
    fun newEmployee(@RequestBody newBook: BookModel): BookModel {
        return repository.save(newBook)
    }

    // Single item
    @GetMapping("/books/{id}")
    fun one(@PathVariable id: Long): BookModel {
        return repository.findById(id)
            .orElseThrow { BookNotFoundException(id) }!!
    }

    @PutMapping("/employees/{id}")
    fun replaceEmployee(@RequestBody newBook: BookModel, @PathVariable id: Long): BookModel {
        return repository.findById(id)
            .map { book ->
                book?.title = newBook.title
                book?.auther = newBook.auther

                repository.save(book!!)
            }
            .orElseGet {
                newBook.id = id
                repository.save(newBook)
            }
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@PathVariable id: Long) {
        repository.deleteById(id)
    }
}