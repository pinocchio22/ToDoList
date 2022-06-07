package com.example.todolist.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author CHOI
 * @email vviian.2@gmail.com
 * @created 2022-06-07
 * @desc
 */

@Entity
data class ToDoEntity (
    @PrimaryKey(autoGenerate = true) var id : Int ?= null,
    @ColumnInfo(name="title") val title : String,
    @ColumnInfo(name="importance") val importance : Int
    )