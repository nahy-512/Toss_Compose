package com.compose.toss.data

import androidx.annotation.StringRes
import com.compose.toss.R

data class Assets(
    val bankType: BankType,
    val name: String,
    val sum: Int,
    val showButton: Boolean
)

//TODO: AssetType(입출금통장, 적금, 포인트 등) 및 즐겨찾기 필드 추가
val assets = listOf(
    Assets(BankType.Shinhan, "저축예금", 158409, true),
    Assets(BankType.Toss, "토스뱅크 통장", 157, true),
    Assets(BankType.Woori, "키즈앤틴즈(Kids & Teens) 통장", 0, true),
    Assets(BankType.Hana, "신한S-MORE(에스모어)", 0, true),
    Assets(BankType.Shinhan, "저축 · 신한 청년저축왕 적금", 1500000, false),
    Assets(BankType.Naver, "포인트 · 머니 · 1개", 0, false),
    Assets(BankType.Kakao, "투자 모아보기 · 1개", 0, false),
)