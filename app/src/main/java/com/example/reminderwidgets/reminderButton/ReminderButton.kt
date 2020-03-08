package com.example.reminderwidgets.reminderButton

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RelativeLayout
import com.example.reminderwidgets.R
import kotlinx.android.synthetic.main.reminder_button.view.*

class ReminderButton : RelativeLayout {
    var reminderButton: Button

    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        LayoutInflater.from(context).inflate(R.layout.reminder_button, this, true)

        progress_circle.elevation = 1000f

        reminderButton = reminder_button
    }
}
