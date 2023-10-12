package com.example.composecore.extensions

import java.text.DecimalFormat

fun Long.toMoney() =  DecimalFormat("#,##0").format(this)