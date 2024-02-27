//package com.example.composecore.overlay
//
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.gestures.detectHorizontalDragGestures
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Rect
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Paint
//import androidx.compose.ui.graphics.Path
//import androidx.compose.ui.graphics.drawscope.clipPath
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun SplitImageView(
//    imageAPainter: Painter,
//    imageBPainter: Painter,
//    modifier: Modifier = Modifier
//) {
//    var dividerPosition by remember { mutableStateOf(0.5f) }
//    val touchAreaWidth =
//        with(LocalDensity.current) { 24.dp.toPx() } // Adjust touch area width as needed
//
//    Box(modifier = modifier) {
//        Canvas(modifier = Modifier
//            .fillMaxSize()
//            .pointerInput(Unit) {
//                detectHorizontalDragGestures { _, dragAmount ->
//                    dividerPosition = (dividerPosition + dragAmount / size.width)
//                        .coerceIn(0f, 1f)
//                }
//            }) {
//            val circlePath = Path().apply {
//                addOval(Rect(Offset.Zero, size))
//            }
//            val dividerX = size.width * dividerPosition
//            clipPath(circlePath) {
//                // Draw Image A
//                with(imageAPainter) {
//                    draw(size, Offset(-dividerX, 0f), alpha = 1f)
//                }
//                // Draw Image B
//                with(imageBPainter) {
//                    draw(size, Offset(size.width - dividerX, 0f), alpha = 1f)
//                }
//            }
//            // Draw Divider Line
//            drawLine(
//                color = Color.Black,
//                start = Offset(dividerX, 0f),
//                end = Offset(dividerX, size.height),
//                strokeWidth = 4f
//            )
//        }
//    }
//}
//
//fun Painter.draw(size: Size, offset: Offset, alpha: Float) {
//    this.apply {
//        val paint = Paint().asFrameworkPaint().apply {
//            this.alpha = (alpha * 255).toInt()
//        }
//        drawIntoCanvas { canvas ->
//            val frameworkImage = this@draw.intrinsicSize
//            val src = Rect(
//                offset.x,
//                offset.y,
//                offset.x + frameworkImage.width,
//                offset.y + frameworkImage.height
//            )
//            val dst = Rect(0f, 0f, size.width, size.height)
//            canvas.drawImageRect(
//                image = this@draw.asImageBitmap(),
//                src = src,
//                dst = dst,
//                paint = paint
//            )
//        }
//    }
//}