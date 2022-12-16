package com.coderboot.compose_ui_components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Error(error: String)
{
    // Snackbar(
    //     action = {},
    //     modifier = Modifier.padding(16.dp)
    // ) { Text(text = error) }

    Toast.makeText(LocalContext.current, error, Toast.LENGTH_SHORT).show()
}