package br.com.lucasisrael.jetposemovies.common.utils.time

import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.MINUTES_IN_HOUR

fun Int.fromMinutesToHours(): Double {
    return (this / MINUTES_IN_HOUR).toDouble()
}
