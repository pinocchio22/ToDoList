package com.example.todolist.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * @author CHOI
 * @email vviian.2@gmail.com
 * @created 2022-06-07
 * @desc
 */
@Dao
interface ToDoDao {
    @Query("SELECT * FROM ToDoEntity")
    fun getAll() : List<ToDoEntity>

    @Insert
    fun insertTodo(todo : ToDoEntity)

    @Delete
    fun deleteTodo(todo : ToDoEntity)
}