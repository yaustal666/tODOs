package com.yaustal666.todos.task

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todolist.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskFragment : Fragment(R.layout.fragment_task_list) {

    private val viewModel: TaskViewModel by viewModels()
}