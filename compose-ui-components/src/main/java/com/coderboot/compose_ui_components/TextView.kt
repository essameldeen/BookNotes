package com.coderboot.compose_ui_components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.coderboot.compose_ui_components.theme.PrimaryColor

@Composable
fun TextView(modifier: Modifier = Modifier, text: String, color: Color = PrimaryColor, size: Int = 24, fontWeight: FontWeight = FontWeight.SemiBold, maxLines: Int = Int.MAX_VALUE, overflow: TextOverflow = TextOverflow.Visible)
{
    Text(modifier = modifier,
        text = text,
        maxLines = maxLines,
        overflow = overflow,
        style = TextStyle(
        color = color,
        fontSize = size.sp,
        fontWeight = fontWeight,
    ))
}