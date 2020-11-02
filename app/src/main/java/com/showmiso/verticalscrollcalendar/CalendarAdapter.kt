package com.showmiso.verticalscrollcalendar

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


    inner class MonthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class DayEmptyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
