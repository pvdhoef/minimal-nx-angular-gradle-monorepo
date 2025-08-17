package com.pvdhoef.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import com.pvdhoef.library.LibraryService

@SpringBootApplication(scanBasePackages = ["com.pvdhoef.library"])
@RestController
class Application(val libraryService: LibraryService) {

    // private val libraryService: LibraryService

    init {
        // libraryService = LibraryService()
        println("Library Service initialized with message: '${libraryService.message()}'")
    }

    @GetMapping("/")
    fun home(): String {
        return libraryService.message();
    }
}

fun main(args: Array<String>) {
    println("Starting Spring Boot application...")
    for (arg in args) {
        println("Argument: '${arg}'")
    }
    runApplication<Application>(*args)
}
