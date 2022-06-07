package com.example.todolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author CHOI
 * @email vviian.2@gmail.com
 * @created 2022-06-07
 * @desc
 */

@Database(entities = [ToDoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTodoDao() : ToDoDao

    companion object {
        val databaseName = "db_toto"
        var appDatabase : AppDatabase ?= null

        fun getInstance(context : Context) : AppDatabase? {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, databaseName).build()
            }
            return appDatabase
        }
    }
}