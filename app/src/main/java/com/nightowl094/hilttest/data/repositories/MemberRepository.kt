package com.nightowl094.hilttest.data.repositories

import androidx.lifecycle.LiveData
import com.nightowl094.hilttest.data.dao.MemberDao
import com.nightowl094.hilttest.data.entities.Member
import javax.inject.Inject

class MemberRepository @Inject constructor(
    private val memberDao: MemberDao
) {
    fun loadAll(): LiveData<List<Member>> = memberDao.loadAll()
    fun insert(member: Member) = memberDao.insert(member)
}