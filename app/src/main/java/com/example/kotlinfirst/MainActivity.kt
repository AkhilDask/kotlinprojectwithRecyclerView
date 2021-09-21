package com.example.kotlinfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = MyAdapter(mutableListOf())

        toDoItem.adapter = todoAdapter
        toDoItem.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener {
            val todotitle = edit.text.toString()
            if (todotitle.isNotEmpty()){
                val todo = Todo(todotitle)
                todoAdapter.addto(todo)
                edit.text.clear()
            }
        }
        delete.setOnClickListener {
            todoAdapter.deleteToDo()
        }
    }

}