package br.com.lucasisrael.jetposemovies.common.utils.types.values.time

const val HOUR = 60

fun Int.fromHoursToMinutes(): Double {
    return (this * HOUR).toDouble()
}

fun Int.fromMinutesToHours(): Double {
    return (this / HOUR).toDouble()
}
