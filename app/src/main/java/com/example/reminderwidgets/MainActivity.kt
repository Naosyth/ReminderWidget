package com.example.reminderwidgets

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reminderwidgets.data.reminder.ReminderListAdapter
import com.example.reminderwidgets.data.reminder.ReminderViewModel
import com.example.reminderwidgets.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var reminderViewModel: ReminderViewModel
    private lateinit var reminderListAdapter: ReminderListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reminderViewModel = ViewModelProvider(this).get(ReminderViewModel::class.java)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.reminderViewModel = reminderViewModel

        setSupportActionBar(toolbar)

        reminderListAdapter = ReminderListAdapter(this)
        reminderListAdapter.setListener(object: ReminderListAdapter.AdapterListener {
            override fun onProgressButtonClicked() {
                val toast = Toast.makeText(applicationContext, "Hello", Toast.LENGTH_LONG)
                toast.show()
            }
        })
        reminderRecyclerView.adapter = reminderListAdapter
        linearLayoutManager = LinearLayoutManager(this)
        reminderRecyclerView.layoutManager = linearLayoutManager

        reminderViewModel.allReminders.observe(this, Observer { reminders ->
            reminders?.let { reminderListAdapter.setReminders(it) }
        })

//        fab.setOnClickListener { _ ->
//            val intent = Intent(this, CreateReminderActivity::class.java)
//            startActivity(intent)
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
