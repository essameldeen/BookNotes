package com.coderboot.compose_ui_components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.coderboot.compose_ui_components.theme.BackgroundColor
import com.coderboot.compose_ui_components.theme.PrimaryColor

@Composable
fun FAB(icon: ImageVector, action: () -> Unit) {
    FloatingActionButton(
        onClick = action,
        backgroundColor = BackgroundColor,
        contentColor = PrimaryColor,
        elevation = FloatingActionButtonDefaults.elevation(7.dp)
    ) {
        Icon(icon, contentDescription = "")
    }
}