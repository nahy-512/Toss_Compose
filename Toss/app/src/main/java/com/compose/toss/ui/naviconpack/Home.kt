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

public val NavIconPack.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(name = "Home", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFB0B8C1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.1643f, 6.6376f)
                lineTo(11.2214f, 1.4193f)
                curveTo(10.4821f, 0.8602f, 9.4857f, 0.8602f, 8.7464f, 1.4193f)
                lineTo(1.8036f, 6.6376f)
                curveTo(1.2893f, 7.0104f, 1.0f, 7.6005f, 1.0f, 8.1907f)
                verticalLineTo(16.5772f)
                curveTo(1.0f, 17.9129f, 2.125f, 19.0f, 3.5071f, 19.0f)
                horizontalLineTo(8.3286f)
                verticalLineTo(14.6514f)
                curveTo(8.3286f, 14.6514f, 8.425f, 14.434f, 8.5536f, 14.434f)
                horizontalLineTo(11.4143f)
                curveTo(11.4143f, 14.434f, 11.6393f, 14.5272f, 11.6393f, 14.6514f)
                verticalLineTo(19.0f)
                horizontalLineTo(16.6214f)
                curveTo(17.9393f, 19.0f, 19.0f, 17.975f, 19.0f, 16.7015f)
                verticalLineTo(8.1596f)
                curveTo(19.0f, 7.5384f, 18.7107f, 6.9793f, 18.1964f, 6.6066f)
                lineTo(18.1643f, 6.6376f)
                close()
            }
        }
        .build()
        return _home!!
    }

private var _home: ImageVector? = null
