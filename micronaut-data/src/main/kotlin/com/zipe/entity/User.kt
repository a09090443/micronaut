package com.zipe.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @NotNull
    var name: String
)
