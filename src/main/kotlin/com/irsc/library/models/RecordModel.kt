package com.irsc.library.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.Date

@Entity
class RecordModel (
    var from:Date?=Date(),
    var to:Date?=null,
)
{

    @Id
    @GeneratedValue
    var id:Long = 0

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patron_id")
    var patron:PatronModel?=null

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_id")
    var book:BookModel?=null

    override fun equals(other: Any?): Boolean {
        return super.equals((other as? RecordModel)?.id == id)
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}