package com.coderboot.compose_ui_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.coderboot.compose_ui_components.theme.PrimaryColor

@Composable
fun InputView(modifier: Modifier = Modifier.fillMaxWidth(), input: MutableState<String>, label: String, keyboardType: KeyboardType, icon: ImageVector? = null, maxLines: Int = 1, radius: Int = 30, enabled: Boolean = true, isOutlined: Boolean = false)
{
    if (isOutlined)
    {
        OutlinedTextField(input.value,
            modifier = modifier,
            visualTransformation = if(keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            enabled = enabled,
            shape = RoundedCornerShape(radius.dp),
            placeholder = { Text(text = label) },
            leadingIcon = if (icon != null) { { Icon(icon, contentDescription = "", tint = PrimaryColor) } } else null,
            label = { Text(text = label) },
            maxLines = maxLines,
            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = PrimaryColor, cursorColor = PrimaryColor, trailingIconColor = PrimaryColor),
            onValueChange = {
                input.value = it
        })
    }
    else
    {
        TextField(input.value,
            modifier = modifier,
            visualTransformation = if(keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            enabled = enabled,
            placeholder = { Text(text = label) },
            leadingIcon = if (icon != null) { { Icon(icon, contentDescription = "", tint = PrimaryColor) } } else null,
            label = { Text(text = label) },
            maxLines = maxLines,
            colors = TextFieldDefaults.textFieldColors(textColor = PrimaryColor, cursorColor = PrimaryColor, trailingIconColor = PrimaryColor),
            onValueChange = {
                input.value = it
        })
    }
}