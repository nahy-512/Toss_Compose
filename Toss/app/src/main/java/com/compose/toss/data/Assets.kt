package com.compose.toss.data

import androidx.annotation.StringRes
import com.compose.toss.R

data class Assets(
    val bankType: BankType,
    @StringRes val name: Int,
    val sum: Int,
    val canRemit: Boolean
)

//TODO: AssetType(입출금통장, 적금, 포인트 등) 및 즐겨찾기 필드 추가
val assets = listOf(
    Assets(BankType.Shinhan, R.string.assets_name_1, 158409, true),
    Assets(BankType.Toss, R.string.assets_name_2, 157, true),
    Assets(BankType.Woori, R.string.assets_name_3, 0, true),
    Assets(BankType.Hana, R.string.assets_name_4, 0, true),
    Assets(BankType.Shinhan, R.string.assets_name_5, 1500000, false),
    Assets(BankType.Naver, R.string.assets_name_6, 0, false),
    Assets(BankType.Kakao, R.string.assets_name_7, 0, false),
)