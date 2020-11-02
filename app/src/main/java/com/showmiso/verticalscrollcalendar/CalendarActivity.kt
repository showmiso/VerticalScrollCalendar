package com.showmiso.verticalscrollcalendar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        initUI()
    }

    private fun initUI() {
        img_back.setOnClickListener(onClickListener)
        text_today.setOnClickListener(onClickListener)

        val list = createCalendarInfo()
        val adapter = CalendarAdapter()
        adapter.list = list
        val layoutManager = StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL)
        rcv_calendar.layoutManager = layoutManager
        rcv_calendar.adapter = adapter
    }

    private fun createCalendarInfo(): ArrayList<PeriodDate> {
        val cal = GregorianCalendar()
        val list = ArrayList<PeriodDate>()

        for (i in -10..10) {
            val calendar = GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + i, 1)
            // today
            val today = GregorianCalendar.getInstance(Locale.KOREA)
            val todayYear = today.get(Calendar.YEAR)
            val todayMonth = today.get(Calendar.MONTH) + 1
            val todayDay = today.get(Calendar.DAY_OF_MONTH)

            // add month
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH) + 1
            val monthDate = PeriodDate(DateType.VIEW_TYPE_MONTH, year, month)
            list.add(monthDate)
            if (year == todayYear && month == todayMonth) {
                position = list.size - 1
            }

            // dayOfWeek is not inclusive
            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1
            val maxDayOfWeek = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            for (j in 0 until dayOfWeek) {
                val date = PeriodDate(DateType.VIEW_TYPE_DAY_EMPTY)
                list.add(date)
            }

            // maxDayOfWeek is inclusive
            for (k in 1..maxDayOfWeek) {
                val dayCalendar =
                    GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), k)
                val day = dayCalendar.get(Calendar.DAY_OF_MONTH)
                // TODO: 임시값
                val isPeriod = day >= 28 || day < 3
                val date = PeriodDate(
                    DateType.VIEW_TYPE_DAY,
                    year, month, day,
                    isFertile = false, isPeriod = isPeriod, hasMemo = false,
                    isToday = month == todayMonth && day == todayDay
                )
                list.add(date)
            }
        }
        return list
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.img_back -> {
                onBackPressed()
            }
            R.id.text_today -> {
                rcv_calendar.scrollToPosition(position)

            }
        }
    }

}