package com.compose.toss.ui.naviconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.compose.toss.ui.NavIconPack

public val NavIconPack.Pay: ImageVector
    get() {
        if (_pay != null) {
            return _pay!!
        }
        _pay = Builder(name = "Pay", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp, viewportWidth
                = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFB0B8C1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(7.9785f, 4.167f)
                curveTo(8.6155f, 4.167f, 8.8393f, 4.167f, 9.4134f, 4.167f)
                curveTo(9.9875f, 4.167f, 10.9092f, 4.167f, 11.4325f, 4.167f)
                curveTo(11.9558f, 4.167f, 11.4325f, 4.167f, 11.926f, 4.167f)
                curveTo(12.4674f, 4.167f, 12.099f, 4.167f, 12.4674f, 4.167f)
                horizontalLineTo(7.5331f)
                curveTo(7.9785f, 4.167f, 7.3414f, 4.167f, 7.9785f, 4.167f)
                close()
                moveTo(5.4183f, 4.167f)
                curveTo(4.4791f, 4.1671f, 6.264f, 4.167f, 7.2647f, 4.167f)
                curveTo(8.4829f, 4.167f, 8.9264f, 4.1671f, 10.1416f, 4.1671f)
                curveTo(11.3568f, 4.1671f, 11.8187f, 4.1677f, 13.1329f, 4.1677f)
                curveTo(14.2406f, 4.1677f, 13.8544f, 4.167f, 14.5822f, 4.167f)
                horizontalLineTo(17.0493f)
                curveTo(17.2227f, 4.1669f, 17.3899f, 4.2371f, 17.5192f, 4.3639f)
                curveTo(17.6484f, 4.4908f, 17.7306f, 4.6656f, 17.75f, 4.8549f)
                lineTo(18.9441f, 16.6233f)
                lineTo(18.9554f, 16.7318f)
                curveTo(18.9864f, 16.9843f, 19.0358f, 17.3995f, 18.9597f, 17.8008f)
                curveTo(18.8785f, 18.2201f, 18.6948f, 18.6071f, 18.4282f, 18.92f)
                curveTo(18.1616f, 19.2329f, 17.8223f, 19.4598f, 17.4469f, 19.5763f)
                curveTo(17.1015f, 19.6816f, 16.7096f, 19.6692f, 16.4713f, 19.6631f)
                lineTo(16.3444f, 19.66f)
                horizontalLineTo(3.656f)
                curveTo(3.6208f, 19.66f, 3.5785f, 19.66f, 3.5292f, 19.6631f)
                curveTo(3.2895f, 19.6692f, 2.8976f, 19.6816f, 2.5536f, 19.5763f)
                curveTo(1.7895f, 19.3439f, 1.2016f, 18.6467f, 1.0408f, 17.8008f)
                curveTo(0.9647f, 17.3995f, 1.0126f, 16.9843f, 1.0437f, 16.7318f)
                lineTo(1.0563f, 16.6233f)
                lineTo(2.2505f, 4.8549f)
                curveTo(2.2699f, 4.6656f, 2.3521f, 4.4908f, 2.4813f, 4.3639f)
                curveTo(2.6106f, 4.2371f, 2.7778f, 4.1669f, 2.9511f, 4.167f)
                horizontalLineTo(5.4183f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFB0B8C1)),
                    strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.75f, 6.7143f)
                verticalLineTo(4.5714f)
                curveTo(6.75f, 3.6242f, 7.0924f, 2.7158f, 7.7019f, 2.0461f)
                curveTo(8.3114f, 1.3763f, 9.1381f, 1.0f, 10.0f, 1.0f)
                curveTo(10.862f, 1.0f, 11.6886f, 1.3763f, 12.2981f, 2.0461f)
                curveTo(12.9076f, 2.7158f, 13.25f, 3.6242f, 13.25f, 4.5714f)
                verticalLineTo(6.7143f)
            }
        }
        .build()
        return _pay!!
    }

private var _pay: ImageVector? = null
