package com.compose.toss.ui

import androidx.compose.ui.graphics.vector.ImageVector
import com.compose.toss.ui.naviconpack.Benefit
import com.compose.toss.ui.naviconpack.Home
import com.compose.toss.ui.naviconpack.Pay
import com.compose.toss.ui.naviconpack.Stock
import com.compose.toss.ui.naviconpack.Whole
import kotlin.collections.List as ____KtList

public object NavIconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val NavIconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Home, Stock, Whole, Benefit, Pay)
    return __AllIcons!!
  }
