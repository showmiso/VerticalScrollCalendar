package com.showmiso.verticalscrollcalendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_calendar_day.view.*
import kotlinx.android.synthetic.main.item_calendar_month.view.*

abstract class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind()
}

class MonthViewHolder(itemView: View) : CalendarViewHolder(itemView) {
    override fun bind() {
        itemView.text_month.text = ""
    }
}

class DayViewHolder(itemView: View) : CalendarViewHolder(itemView) {
    override fun bind() {
        itemView.text_day.text = ""
        itemView.img_selected.visibility = View.GONE
        itemView.img_dot.visibility = View.GONE
        itemView.img_line.visibility = View.VISIBLE
    }
}

class DayEmptyViewHolder(itemView: View) : CalendarViewHolder(itemView) {
    override fun bind() {
    }
}

