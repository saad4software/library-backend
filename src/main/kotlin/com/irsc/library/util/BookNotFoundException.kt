package com.irsc.library.util


internal class BookNotFoundException(id: Long) : RuntimeException("Could not find book $id")