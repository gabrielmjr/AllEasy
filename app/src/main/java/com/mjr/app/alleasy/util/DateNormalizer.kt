package com.mjr.app.alleasy.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateNormalizer {
    private val date = Date()
    private val sdfy = SimpleDateFormat("yyyy", Locale.US)
    private val sdfdy = SimpleDateFormat("DD", Locale.US)
    private val sdfm = SimpleDateFormat("MM", Locale.US)
    private val sdfd = SimpleDateFormat("dd", Locale.US)
    private val sdfM = SimpleDateFormat("mm", Locale.US)
    private val sdfs = SimpleDateFormat("ss", Locale.US)

    private val normalizeDate = IntArray(7)

    private fun normalizedDate(): IntArray {
        normalizeDate[0] = Integer.valueOf(sdfy.format(date))
        normalizeDate[1] = Integer.valueOf(sdfdy.format(date))
        normalizeDate[2] = Integer.valueOf(sdfm.format(date))
        normalizeDate[3] = Integer.valueOf(sdfd.format(date))
        normalizeDate[4] = date.hours
        normalizeDate[5] = Integer.valueOf(sdfM.format(date))
        normalizeDate[6] = Integer.valueOf(sdfs.format(date))
        return normalizeDate
    }

    fun getDate(): Long {
            var timer = ""
            for (x in normalizedDate()) {
                timer += x.toString()
            }
            return java.lang.Long.valueOf(timer) * 2 + 892473
    }

    fun getYear(): Int {
        return normalizeDate[1]
    }
}