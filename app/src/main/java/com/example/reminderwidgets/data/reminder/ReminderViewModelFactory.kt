package com.example.reminderwidgets.data.reminder

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ReminderViewModelFactory(private val application: Application, private val reminderId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReminderViewModel::class.java)) {
            return ReminderViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
