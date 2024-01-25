package com.irsc.library.controllers

import com.irsc.library.repositories.BooksRepository
import com.irsc.library.models.BookModel
import com.irsc.library.util.NotFoundException
import org.hibernate.internal.util.collections.CollectionHelper.listOf
import org.springframework.web.bind.annotation.*


@RestController
internal class BooksController(repository: BooksRepository) {
    private val repository: BooksRepository

    init {
        this.repository = repository
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/books")
    fun all(): Iterable<BookModel?> {
        return repository.findAll()
    }

    // end::get-aggregate-root[]
    @PostMapping("/books")
    fun newItem(@RequestBody newBook: BookModel): BookModel {
        return repository.save(newBook)
    }

    // Single item
    @GetMapping("/books/{id}")
    fun one(@PathVariable id: Long): BookModel {
        return repository.findById(id)
            .orElseThrow { NotFoundException("book",id) }!!
    }

    @PutMapping("/books/{id}")
    fun replaceItem(@RequestBody newBook: BookModel, @PathVariable id: Long): BookModel {
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
    fun deleteItem(@PathVariable id: Long) {
        repository.deleteById(id)
    }
}