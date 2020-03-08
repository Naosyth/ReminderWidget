package com.example.reminderwidgets.data.reminder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Reminder::class], version = 1, exportSchema = false)
abstract class ReminderDatabase : RoomDatabase() {

    abstract fun reminderDao(): ReminderDao

    private class ReminderDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var reminderDao = database.reminderDao()

                    // Delete all content here.
                    reminderDao.deleteAll()

                    // Add sample words.
                    var reminder = Reminder(0, "My first reminder", "Do the thing", 21600000, System.currentTimeMillis())
                    reminderDao.insert(reminder)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ReminderDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ReminderDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReminderDatabase::class.java,
                    "word_database"
                )
                    .addCallback(ReminderDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
