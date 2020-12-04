package com.nightowl094.hilttest.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.nightowl094.hilttest.data.entities.Member

@Dao
interface MemberDao : BaseDao<Member> {

    @Query("SELECT * FROM member")
    fun loadAll(): LiveData<List<Member>>

}