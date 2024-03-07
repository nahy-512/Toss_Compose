package com.compose.toss.data

import androidx.annotation.DrawableRes
import com.compose.toss.R

enum class BankType(val bankName: String, @DrawableRes val logo: Int) {
    Toss("토스뱅크", R.drawable.ic_bank_toss),
    Shinhan("신한은행", R.drawable.ic_bank_shinhan),
    Hana("하나은행", R.drawable.ic_bank_hana),
    Naver("네이버페이", R.drawable.ic_bank_naver),
    Kakao("카카오뱅크", R.drawable.ic_bank_kakao),
    Woori("우리은행", R.drawable.ic_bank_woori);
}