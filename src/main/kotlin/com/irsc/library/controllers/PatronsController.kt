package com.irsc.library.controllers

import com.irsc.library.models.BookModel
import com.irsc.library.models.PatronModel
import com.irsc.library.repositories.BooksRepository
import com.irsc.library.repositories.PatronsRepository
import com.irsc.library.util.NotFoundException
import org.springframework.web.bind.annotation.*

@RestController
internal class PatronsController(var repository: PatronsRepository) {

    @GetMapping("/patrons")
    fun all(): List<PatronModel?> {
        return repository.findAll()
    }

    @PostMapping("/patrons")
    fun newItem(@RequestBody newItem: PatronModel): PatronModel {
        return repository.save(newItem)
    }

    @GetMapping("/patrons/{id}")
    fun one(@PathVariable id: Long): PatronModel {
        return repository.findById(id)
            .orElseThrow { NotFoundException("patron",id) }!!
    }

    @PutMapping("/patrons/{id}")
    fun replaceItem(@RequestBody newItem: PatronModel, @PathVariable id: Long): PatronModel {
        return repository.findById(id)
            .map { item ->
                item?.name = newItem.name
                item?.phone = newItem.phone

                repository.save(item!!)
            }
            .orElseGet {
                newItem.id = id
                repository.save(newItem)
            }
    }

    @DeleteMapping("/patrons/{id}")
    fun deleteItem(@PathVariable id: Long) {
        repository.deleteById(id)
    }


}