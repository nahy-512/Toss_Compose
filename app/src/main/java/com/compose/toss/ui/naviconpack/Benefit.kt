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

public val NavIconPack.Benefit: ImageVector
    get() {
        if (_benefit != null) {
            return _benefit!!
        }
        _benefit = Builder(name = "Benefit", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFB0B8C1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(14.44f, 2.0f)
                horizontalLineTo(5.56f)
                curveTo(5.135f, 2.0f, 4.739f, 2.216f, 4.5089f, 2.5735f)
                lineTo(0.5408f, 8.7387f)
                curveTo(0.2246f, 9.23f, 0.2909f, 9.8749f, 0.7005f, 10.2915f)
                lineTo(9.3305f, 19.0708f)
                curveTo(9.8287f, 19.5776f, 10.6487f, 19.5676f, 11.1344f, 19.0488f)
                lineTo(19.334f, 10.2903f)
                curveTo(19.7255f, 9.8721f, 19.7827f, 9.2413f, 19.4726f, 8.7595f)
                lineTo(15.4911f, 2.5735f)
                curveTo(15.261f, 2.216f, 14.865f, 2.0f, 14.44f, 2.0f)
                close()
            }
        }
        .build()
        return _benefit!!
    }

private var _benefit: ImageVector? = null
