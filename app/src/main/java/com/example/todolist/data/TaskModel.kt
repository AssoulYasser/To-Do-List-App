package com.example.todolist.data

import java.time.LocalTime

data class TaskModel(val id: Long, var title:String, var description:String, var time:String, var isDone:Boolean)