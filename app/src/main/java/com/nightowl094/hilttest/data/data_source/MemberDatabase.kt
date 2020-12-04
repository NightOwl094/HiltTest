package com.nightowl094.hilttest.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nightowl094.hilttest.data.dao.MemberDao
import com.nightowl094.hilttest.data.entities.Member

@Database(entities = [Member::class], version = 1, exportSchema = false)
abstract class MemberDatabase : RoomDatabase() {
    abstract fun memberDao(): MemberDao
}