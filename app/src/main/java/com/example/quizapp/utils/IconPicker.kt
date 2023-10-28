package com.example.quizapp.utils

import com.example.quizapp.R

object IconPicker {
    private val icons = arrayOf(
        R.drawable.ic_icon_1,
        R.drawable.ic_icon_2,
        R.drawable.ic_icon_3,
        R.drawable.ic_icon_4,
        R.drawable.ic_icon_5,
        R.drawable.ic_icon_6,
        R.drawable.ic_icon_7,
        R.drawable.ic_icon_8
    )
    private var currentIcon = 0

    fun getIcon(): Int {
        currentIcon = (currentIcon + 1) % icons.size
        return icons[currentIcon]
    }
}