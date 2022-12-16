package com.coderboot.compose_ui_components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.coderboot.compose_ui_components.theme.BackgroundColor
import com.coderboot.compose_ui_components.theme.PrimaryColor

@Composable
fun ButtonView(label: String, width: ButtonWidth = ButtonWidth.FILLED, action: () -> Unit)
{
    when (width){
        ButtonWidth.WRAPPED -> {
            Button(modifier = Modifier
                .height(50.dp)
                .wrapContentWidth(),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor, contentColor = BackgroundColor),
                onClick = action) {
                Text(text = label)
            }
        }
        ButtonWidth.MEDIUM -> {
            Button(modifier = Modifier
                .height(50.dp)
                .width(buttonWidth(LocalContext.current).dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor, contentColor = BackgroundColor),
                onClick = action) {
                Text(text = label)
            }
        }
        ButtonWidth.FILLED -> {
            Button(modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor, contentColor = BackgroundColor),
                onClick = action) {
                Text(text = label)
            }
        }
    }
}

enum class ButtonWidth{
    WRAPPED, FILLED, MEDIUM
}

private fun buttonWidth(context: Context): Double{
    val displayMetrics = context.resources.displayMetrics
    return displayMetrics.widthPixels * 0.255
}