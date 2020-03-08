package com.example.reminderwidgets.data.reminder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ReminderViewModel(application: Application) : AndroidViewModel(application) {
    val allReminders: LiveData<List<Reminder>>
    private val reminderDao: ReminderDao = ReminderDatabase.getDatabase(application, viewModelScope).reminderDao()

    init {
        allReminders = reminderDao.getAll()
    }

    fun insert(reminder: Reminder) = viewModelScope.launch {
        reminderDao.insert(reminder)
    }
}
