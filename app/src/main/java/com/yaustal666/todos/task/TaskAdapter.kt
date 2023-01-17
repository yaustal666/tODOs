package com.yaustal666.todos.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskBinding
import com.yaustal666.todos.data.Task

class TaskAdapter : ListAdapter<Task, TaskAdapter.TaskViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val curItem = getItem(position)
        holder.bind(curItem)
    }

    class TaskViewHolder(private val binding: TaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task : Task) {
            binding.apply {
                checkboxTaskCompleted.isChecked = task.isCompleted
                taskName.text = task.name
                taskName.paint.isStrikeThruText = task.isCompleted
                checkboxTaskFavorite.isChecked = task.isFavorite
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Task, newItem: Task) =
            oldItem == newItem
    }
}