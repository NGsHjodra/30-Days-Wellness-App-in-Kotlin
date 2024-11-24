package kekw.ngs.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    @DrawableRes val image: Int,
    val day: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
)