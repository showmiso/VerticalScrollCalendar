package com.showmiso.verticalscrollcalendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_calendar_day.view.*
import kotlinx.android.synthetic.main.item_calendar_month.view.*

abstract class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(date: PeriodDate)
}

class MonthViewHolder(itemView: View) : CalendarViewHolder(itemView) {
    override fun bind(date: PeriodDate) {
        itemView.text_month.text = date.month.toString()
    }
}

class DayViewHolder(itemView: View) : CalendarViewHolder(itemView) {
    override fun bind(date: PeriodDate) {
        itemView.text_day.text = date.day.toString()
        itemView.img_selected.visibility = if (date.isToday!!) View.VISIBLE else View.GONE
        itemView.img_dot.visibility = View.GONE
        itemView.img_line.visibility = if (date.isPeriod!!) View.VISIBLE else View.GONE
    }
}

class DayEmptyViewHolder(itemView: View) : CalendarViewHolder(itemView) {
    override fun bind(date: PeriodDate) {
    }
}

