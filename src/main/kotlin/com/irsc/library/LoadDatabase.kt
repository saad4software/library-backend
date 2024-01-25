package com.irsc.library

import com.irsc.library.models.BookModel
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Configuration
internal class LoadDatabase {

    private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)

    @Bean
    fun initDatabase(repository: BooksRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            log.info("Preloading " + repository.save(BookModel("Bilbo Baggins", "burglar")))
            log.info("Preloading " + repository.save(BookModel("Frodo Baggins", "thief")))
        }
    }


}