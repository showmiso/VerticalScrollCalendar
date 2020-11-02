package com.showmiso.verticalscrollcalendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter : RecyclerView.Adapter<CalendarViewHolder>() {

    private val VIEW_TYPE_MONTH = 0
    private val VIEW_TYPE_DAY = 1
    private val VIEW_TYPE_DAY_EMPTY = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.item_calendar_month, parent, false)
                return MonthViewHolder(view)
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.item_calendar_day, parent, false)
                return DayViewHolder(view)
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.item_calendar_day_empty, parent, false)
                return DayEmptyViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

}
