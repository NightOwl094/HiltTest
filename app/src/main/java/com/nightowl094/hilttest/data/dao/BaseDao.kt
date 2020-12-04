package com.nightowl094.hilttest.data.dao

import androidx.annotation.WorkerThread
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @WorkerThread
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T)

    @WorkerThread
    @Update
    fun update(vararg obj: T)

    @WorkerThread
    @Delete
    fun delete(vararg obj: T)
}