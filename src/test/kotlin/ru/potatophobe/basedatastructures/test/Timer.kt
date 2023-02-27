package ru.potatophobe.basedatastructures.test

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

object Timer {

    fun measure(action: () -> Unit): Duration {
        val startTimeMillis = System.currentTimeMillis()
        action.invoke()
        val endTimeMillis = System.currentTimeMillis()
        return (endTimeMillis - startTimeMillis).milliseconds
    }
}
