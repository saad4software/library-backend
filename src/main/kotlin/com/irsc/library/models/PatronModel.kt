package com.irsc.library.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.ArrayList


@Entity
class PatronModel (
    var name:String?=null,
    var phone:String?=null,
)
{
    @Id
    @GeneratedValue
    var id:Long = 1

    @JsonIgnore
    @OneToMany(mappedBy = "patron")
    var records: List<RecordModel> = ArrayList()


    override fun equals(other: Any?): Boolean {
        return super.equals((other as? PatronModel)?.id == id)
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}