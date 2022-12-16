package com.coderboot.compose_ui_components

import android.view.ContextThemeWrapper
import android.widget.CalendarView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import java.util.*

@Composable
fun CalendarView(initialDate: Long = Date().time, listener: (Long) -> Unit = { }) {
    AndroidView(modifier = Modifier.fillMaxWidth(), factory = { CalendarView(ContextThemeWrapper(it, R.style.CalendarTheme)) }, update = {
        it.date = initialDate
        it.setOnDateChangeListener { view, year, month, day ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            listener(calendar.time.time)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    CalendarView()
}