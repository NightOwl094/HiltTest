package com.nightowl094.hilttest.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Member(
    @PrimaryKey
    val memberIdx: Int,
    val memberName: String
)

