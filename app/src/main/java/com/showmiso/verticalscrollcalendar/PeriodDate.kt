package com.showmiso.verticalscrollcalendar

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
    val isFertile: Boolean? = null,
    val isPeriod: Boolean? = null,
    val hasMemo: Boolean? = null,
    val isToday: Boolean? = false
)