package com.coderboot.compose_ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ImageView(painter: Painter, size: Int = 24, scale: ContentScale = ContentScale.Fit)
{
    Image(
        painter = painter,
        contentDescription = "",
        contentScale = scale,
        modifier = Modifier.fillMaxWidth().height(size.dp)
    )
}