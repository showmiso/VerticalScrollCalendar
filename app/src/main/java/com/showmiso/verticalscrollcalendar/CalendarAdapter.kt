package com.showmiso.verticalscrollcalendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.util.ArrayList

class CalendarAdapter : RecyclerView.Adapter<CalendarViewHolder>() {

    var list = ArrayList<PeriodDate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.item_calendar_month, parent, false)
                val params: StaggeredGridLayoutManager.LayoutParams = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
                params.isFullSpan = true
                view.layoutParams = params
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
        val date = list[position]
        holder.bind(date)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type.ordinal
    }

}
