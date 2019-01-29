@file:JvmName("DateUtils")
package com.xzm.tyb.utils

import java.text.ParseException
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*
val calendar= Calendar.getInstance()!!
fun Date.format(format:String,locale: Locale)= SimpleDateFormat(format,locale).format(this)!!
fun Date.format(format:String)=this.format(format,Locale.getDefault())
fun String.parse(format:String,locale: Locale)= SimpleDateFormat(format,locale).parse(this)!!
fun Date.year():Int{
    calendar.time=this
    return calendar.get(Calendar.YEAR)
}
fun Date.month():Int{
    calendar.time=this
    return calendar.get(Calendar.MONTH)
}
fun Date.day():Int{
    calendar.time=this
    return calendar.get(Calendar.DAY_OF_MONTH)
}
fun Date.hour():Int{
    calendar.time=this
    return calendar.get(Calendar.HOUR)
}
fun String.parse(vararg formats:String,locale: Locale=Locale.getDefault()):Date{
    for(format in formats) {
        val pos = ParsePosition(0)
        val result = SimpleDateFormat(format, locale).parse(this, pos)
        if (pos.index == 0) continue
        else return result
    }
    throw ParseException("Unparseable date: \"$this\"",-1)
}