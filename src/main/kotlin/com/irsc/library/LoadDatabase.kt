package com.irsc.library

import com.irsc.library.models.BookModel
import com.irsc.library.models.PatronModel
import com.irsc.library.repositories.BooksRepository
import com.irsc.library.repositories.PatronsRepository
import com.irsc.library.repositories.RecordsRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Configuration
internal class LoadDatabase {

    private val log: Logger = LoggerFactory.getLogger("LoadDatabase")

    @Bean
    fun initDatabase(
        booksRepository: BooksRepository,
        patronsRepository: PatronsRepository,
        recordsRepository: RecordsRepository,
    ): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
//            repository.save(BookModel("Wonderful wizard of OZ", "arther", 1934))
            log.info("Preloading " + booksRepository.save(BookModel("Wonderful world", "burglar")))
            log.info("Preloading " + booksRepository.save(BookModel("Alice in the wonderland", "thief")))
            log.info("Preloading " + patronsRepository.save(PatronModel("Alex", "099887876")))
            log.info("Preloading " + patronsRepository.save(PatronModel("Peter", "09966568")))
        }
    }


}