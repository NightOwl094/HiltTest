package com.nightowl094.hilttest.view_models

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nightowl094.hilttest.data.entities.Member
import com.nightowl094.hilttest.data.repositories.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(
    private val memberRepository: MemberRepository
) : ViewModel() {

    fun loadAll(): LiveData<List<Member>> =
        memberRepository.loadAll()

    fun insert(member: Member): Job =
        viewModelScope.launch(Dispatchers.IO) { memberRepository.insert(member) }

}