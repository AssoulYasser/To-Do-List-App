package com.example.todolist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.todolist.R
import com.example.todolist.Retrofit.HttpRequest
import com.example.todolist.data.TaskModel
import kotlinx.android.synthetic.main.activity_task_form.*

class TaskDetailsActivity : AppCompatActivity() {
    private val contextTaskDetailsActivity = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_form)

        delBtn.visibility = View.VISIBLE

        titleTV.setText(intent.getStringExtra("title"))
        descriptionTV.setText(intent.getStringExtra("description"))
        hourTV.setText(intent.getStringExtra("time")?.split(":")?.get(0) ?: "")
        minutTV.setText(intent.getStringExtra("time")?.split(":")?.get(1) ?: "")
        addBtn.text = "UPDATE"





        addBtn.setOnClickListener{
            val data = TaskModel(
            intent.getLongExtra("id", 0),
            titleTV.text.toString(), descriptionTV.text.toString(),
            "${hourTV.text}:${minutTV.text}:00",
            false
            )
            HttpRequest.updateData(data)
            finish()
        }

        delBtn.setOnClickListener {
            val data = TaskModel(
                intent.getLongExtra("id", 0),
                titleTV.text.toString(), descriptionTV.text.toString(),
                "${hourTV.text}:${minutTV.text}:00",
                false
            )
            HttpRequest.deleteData(data.id)
            finish()
        }

    }
}