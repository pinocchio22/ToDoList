package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todolist.databinding.ActivityAddTodoBinding
import com.example.todolist.db.AppDatabase
import com.example.todolist.db.ToDoDao
import com.example.todolist.db.ToDoEntity

class AddTodoActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddTodoBinding
    lateinit var db : AppDatabase
    lateinit var toDoDao: ToDoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)!!
        toDoDao = db.getTodoDao()

        binding.btnCompletion.setOnClickListener {
            insertTodo()
        }
    }

    // @desc 할 일 추가 함수
    private fun insertTodo() {
        val todoTitle = binding.edtTitle.text.toString()
        var todoImportance = binding.radioGroup.checkedRadioButtonId

        when (todoImportance) {
            R.id.btn_high -> todoImportance = 1
            R.id.btn_middle -> todoImportance = 2
            R.id.btn_low -> todoImportance = 3
            else -> todoImportance = -1
        }
        // 중요도가 선택되지 않았거나, 제목이 작성되지 않았을 경우
        if (todoImportance == -1 || todoTitle.isBlank()) {
            Toast.makeText(this, "작성되지 않은 항목이 있습니다.", Toast.LENGTH_SHORT).show()
        } else {
            Thread {
                toDoDao.insertTodo(ToDoEntity(null, todoTitle, todoImportance))
                runOnUiThread {
                    Toast.makeText(this, "추가되었습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

}