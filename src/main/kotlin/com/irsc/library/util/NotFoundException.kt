package com.irsc.library.util


internal class NotFoundException(name:String, id: Long) : RuntimeException("Could not find $name $id")