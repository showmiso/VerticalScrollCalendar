package com.showmiso.verticalscrollcalendar.calendar

enum class DateType(value: Int) {
    VIEW_TYPE_MONTH(0),
    VIEW_TYPE_DAY(1),
    VIEW_TYPE_DAY_EMPTY(2);
}

class PeriodDate(
    val type: DateType,
    val year: Int? = null,
    val month: Int? = null,
    val day: Int? = null,
    val isFertile: Boolean? = null, // 배란주기
    val isPeriod: Boolean? = null,  // 생리주기
    val hasMemo: Boolean? = null,   // 메모
    val isToday: Boolean? = false   // 오늘
)