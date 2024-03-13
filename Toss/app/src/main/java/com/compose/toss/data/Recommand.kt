package com.compose.toss.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Recommend(
    val icon: ImageVector,
    val iconColor: Color,
    val content: String,
)

//TODO: AssetType(입출금통장, 적금, 포인트 등) 및 즐겨찾기 필드 추가
val recommends = listOf(
    Recommend(Icons.Filled.Call, Color(0xFF0080F2), "보험 전문가에게 물어보기"),
    Recommend(Icons.Filled.AddCircle, Color(0xFF17C27E),"병원비 돌려받기"),
    Recommend(Icons.Filled.ThumbUp, Color(0xFF0EA066),"전세보증금 반환보증"),
)