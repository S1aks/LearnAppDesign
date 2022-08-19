package com.s1aks.learnappdesign.ui.home

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.widget.TextView
import java.text.SimpleDateFormat

class MyTimer(
    countMillis: Long,
    private val d1: TextView,
    private val d2: TextView,
    private val h1: TextView,
    private val h2: TextView,
    private val m1: TextView,
    private val m2: TextView,
) : CountDownTimer(countMillis, 60000) {

    @SuppressLint("SimpleDateFormat")
    override fun onTick(millisUntilFinished: Long) {
        val format = SimpleDateFormat("dd:HH:mm")
        val stringTime: String = format.format(millisUntilFinished)
        d1.text = stringTime[0].toString()
        d2.text = stringTime[1].toString()
        h1.text = stringTime[3].toString()
        h2.text = stringTime[4].toString()
        m1.text = stringTime[6].toString()
        m2.text = stringTime[7].toString()
    }

    override fun onFinish() {
        d1.text = "0"
        d2.text = "0"
        h1.text = "0"
        h2.text = "0"
        m1.text = "0"
        m2.text = "0"
    }
}