package com.irsc.library.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class BookModel(
    var title:String?=null,
    var auther:String?=null,
    var publicationYear: Int?=null,
)
{

    @Id
    @GeneratedValue
    var id:Long = 0

    override fun equals(other: Any?): Boolean {
        return super.equals((other as? BookModel)?.id == id)
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}