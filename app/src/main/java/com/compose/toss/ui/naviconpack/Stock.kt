package com.compose.toss.ui.naviconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.compose.toss.ui.NavIconPack

public val NavIconPack.Stock: ImageVector
    get() {
        if (_stock != null) {
            return _stock!!
        }
        _stock = Builder(name = "Stock", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFB0B8C1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(1.25f, 17.5f)
                verticalLineTo(9.9399f)
                curveTo(1.25f, 9.6596f, 1.3677f, 9.3922f, 1.5743f, 9.2028f)
                lineTo(6.5898f, 4.6052f)
                curveTo(6.9656f, 4.2607f, 7.5404f, 4.2541f, 7.924f, 4.5898f)
                lineTo(10.6202f, 6.949f)
                curveTo(10.9847f, 7.2679f, 11.5253f, 7.2798f, 11.9034f, 6.9773f)
                lineTo(17.1253f, 2.7998f)
                curveTo(17.7801f, 2.2759f, 18.75f, 2.7421f, 18.75f, 3.5806f)
                verticalLineTo(17.5f)
                curveTo(18.75f, 18.0523f, 18.3023f, 18.5f, 17.75f, 18.5f)
                horizontalLineTo(2.25f)
                curveTo(1.6977f, 18.5f, 1.25f, 18.0523f, 1.25f, 17.5f)
                close()
            }
        }
        .build()
        return _stock!!
    }

private var _stock: ImageVector? = null
