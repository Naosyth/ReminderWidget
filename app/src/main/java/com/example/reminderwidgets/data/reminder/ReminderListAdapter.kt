package com.example.reminderwidgets.data.reminder

import android.content.Context
import android.view.*
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.reminderwidgets.R
import com.example.reminderwidgets.reminderButton.ReminderButton
import kotlinx.android.synthetic.main.reminder_button.view.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ReminderListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<ReminderListAdapter.ReminderViewHolder>() {
    //private lateinit var reminderViewModel: ReminderViewModel
    private val layoutInflater = LayoutInflater.from(context)
    private val menuInflater = MenuInflater(context)
    private var reminders = emptyList<Reminder>()
    var selectedReminder: Reminder? = null

    interface AdapterListener {
        fun onProgressButtonClicked()
    }

    private var listener: AdapterListener? = null

    fun setListener(listener: AdapterListener) {
        this.listener = listener
    }

    inner class ReminderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
        var reminder: Reminder? = null
        var reminderTitle: TextView = itemView.findViewById(R.id.reminder_title_text)
        var reminderDescription: TextView = itemView.findViewById(R.id.reminder_description_text)
        val reminderProgressButton: ReminderButton = itemView.findViewById(R.id.reminder_progress_button)

        init {
            //reminderViewModel = ViewModelProvider(this).get(ReminderViewModel::class.java)
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            view: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
        val itemView = layoutInflater.inflate(R.layout.reminder_listitem, parent, false)
        return ReminderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        val reminder = reminders[position]
        holder.reminder = reminder
        holder.reminderTitle.text = reminder.name
        holder.reminderDescription.text = reminder.description
        holder.reminderProgressButton.reminder_button.setOnClickListener {
            MainScope().launch {
                listener?.onProgressButtonClicked()
            }
        }
    }

    internal fun setReminders(reminders: List<Reminder>) {
        this.reminders = reminders
        notifyDataSetChanged()
    }

    override fun getItemCount() = reminders.size
}
