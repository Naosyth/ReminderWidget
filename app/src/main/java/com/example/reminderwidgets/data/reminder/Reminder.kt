package com.example.reminderwidgets.data.reminder

import androidx.room.*

@Entity
data class Reminder(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "timer") var timer: Int,
    @ColumnInfo(name = "last_activated") var lastActivated: Long
)
