package com.showmiso.verticalscrollcalendar.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.showmiso.verticalscrollcalendar.R
import kotlinx.android.synthetic.main.item_calendar_day.view.*
import kotlinx.android.synthetic.main.item_calendar_month.view.*

class CalendarAdapter : RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {
    private val list = mutableListOf<PeriodDate>()
    private var isEditMode: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.item_calendar_month, parent, false)
                val params: StaggeredGridLayoutManager.LayoutParams =
                    view.layoutParams as StaggeredGridLayoutManager.LayoutParams
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

    fun setList(pList: List<PeriodDate>) {
        list.clear()
        list.addAll(pList)
        notifyDataSetChanged()
    }

    fun setEditMode(mode: Boolean) {
        isEditMode = mode
        if (isEditMode) {

        } else {

        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type.ordinal
    }

    abstract class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(date: PeriodDate)
    }

    class MonthViewHolder(itemView: View) : CalendarViewHolder(itemView) {
        override fun bind(date: PeriodDate) {
            itemView.text_month.text = date.month.toString()
        }
    }

    inner class DayViewHolder(itemView: View) : CalendarViewHolder(itemView) {
        override fun bind(date: PeriodDate) {
            if (isEditMode) {

            } else {
                itemView.text_day.text = date.day.toString()
                itemView.img_selected.visibility = if (date.isToday!!) View.VISIBLE else View.GONE
                itemView.img_dot.visibility = View.GONE
                itemView.img_line.visibility = if (date.isPeriod!!) View.VISIBLE else View.GONE
            }
        }
    }

    class DayEmptyViewHolder(itemView: View) : CalendarViewHolder(itemView) {
        override fun bind(date: PeriodDate) {
        }
    }
}
