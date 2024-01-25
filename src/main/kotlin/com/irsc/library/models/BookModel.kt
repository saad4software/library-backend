package com.irsc.library.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
class BookModel(
    var title:String?=null,
    var auther:String?=null,
    var publicationYear: Int?=null,
)
{

    @Id
    @GeneratedValue
    var id:Long = 1

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    var records: List<RecordModel> = ArrayList()


    override fun equals(other: Any?): Boolean {
        return super.equals((other as? BookModel)?.id == id)
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}