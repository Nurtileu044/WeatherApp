package kz.ablazim.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {

    private const val PATTERN_TIME = "HH:mm"

    fun getFormattedDate(date: Long): String =
        SimpleDateFormat(PATTERN_TIME, Locale.US).format(date)
}