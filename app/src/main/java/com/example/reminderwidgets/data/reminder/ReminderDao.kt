package com.example.reminderwidgets.data.reminder

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReminderDao {
    @Query("Select * FROM reminder")
    fun getAll(): LiveData<List<Reminder>>

    @Query("Select * FROM reminder WHERE id = :reminderId")
    fun findById(reminderId: Int): Reminder

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(reminder: Reminder)

    @Query("DELETE FROM reminder")
    suspend fun deleteAll()
}
