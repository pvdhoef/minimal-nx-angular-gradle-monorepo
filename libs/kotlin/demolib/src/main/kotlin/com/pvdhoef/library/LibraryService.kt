package com.pvdhoef.library

import org.springframework.stereotype.Service

@Service
class LibraryService {
    fun message(): String {
        return "Hello from LibraryService!"
    }
}
