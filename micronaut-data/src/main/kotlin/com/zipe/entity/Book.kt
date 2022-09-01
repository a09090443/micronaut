package com.zipe.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
data class Book(

    @Id
    var id: Long? = null,

    @NotNull
    var name: String
)
