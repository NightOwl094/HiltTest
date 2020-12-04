package com.nightowl094.hilttest.di

import android.content.Context
import androidx.room.Room
import com.nightowl094.hilttest.data.dao.MemberDao
import com.nightowl094.hilttest.data.data_source.MemberDatabase
import com.nightowl094.hilttest.data.repositories.MemberRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun provideMemberDB(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(appContext, MemberDatabase::class.java, "member.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMemberDao(memberDb: MemberDatabase): MemberDao =
        memberDb.memberDao()

    @Singleton
    @Provides
    fun provideMemberRepository(memberDao: MemberDao): MemberRepository =
        MemberRepository(memberDao)
}