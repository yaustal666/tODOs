package com.yaustal666.todos.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.yaustal666.todos.data.FilterPreferences
import com.yaustal666.todos.data.PreferencesManager
import com.yaustal666.todos.data.Task
import com.yaustal666.todos.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskDao : TaskDao,
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    val prefFlow = preferencesManager.prefFlow

    private val taskFlow = prefFlow.flatMapLatest {
        taskDao.getCompleted(it.hideCompleted)
    }

    val tasks = taskFlow.asLiveData()

    fun onHideCompletedSelected(hideCompleted : Boolean) = viewModelScope.launch {
        preferencesManager.updateHideCompleted(hideCompleted)
    }

    fun onTaskSelected(task: Task) {

    }

    fun onTaskCheckedChanged(task: Task, isChecked: Boolean) = viewModelScope.launch {
        taskDao.updateTask(task.copy(isCompleted = isChecked))
    }

    fun onTaskFavoriteChanged(task: Task, isChecked: Boolean) = viewModelScope.launch {
        taskDao.updateTask(task.copy(isFavorite = isChecked))
    }

}