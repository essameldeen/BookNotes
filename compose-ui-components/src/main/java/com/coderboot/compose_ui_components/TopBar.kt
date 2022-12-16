package com.coderboot.compose_ui_components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.coderboot.compose_ui_components.theme.BackgroundColor
import com.coderboot.compose_ui_components.theme.PrimaryColor

@Composable
fun TopBar(icon: ImageVector, label: String, navigationAction: () -> Unit)
{
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = navigationAction) {
                Icon(icon, "", tint = PrimaryColor)
            }
        },
        title = { TextView(text = label, color = PrimaryColor, size = 16, fontWeight = FontWeight.Medium) },
        elevation = 5.dp,
        backgroundColor = BackgroundColor,
    )
}