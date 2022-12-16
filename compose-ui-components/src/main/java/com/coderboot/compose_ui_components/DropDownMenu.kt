package com.coderboot.compose_ui_components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize

@Composable
fun DropMenu(items: Array<String> = arrayOf()) {

    val viewWidth = remember { mutableStateOf(Size.Zero) }

    val isExpanded = remember { mutableStateOf(false) }

    val selectedItem = remember { mutableStateOf(items[0]) }

    val selectAndDismiss = { item: String ->
        isExpanded.value = false
        selectedItem.value = item
    }

    val toggle: () -> Unit = {
        isExpanded.value = !isExpanded.value
    }

    Column {
        Button(
            modifier = Modifier.onGloballyPositioned { viewWidth.value = it.size.toSize() },
            onClick = toggle,
            colors = ButtonDefaults.outlinedButtonColors())
        {
            Row {
                Text(text = selectedItem.value, modifier = Modifier.weight(1f))
                Icon(Icons.Outlined.ArrowDropDown, contentDescription = "")
            }
        }
        DropdownMenu(
            modifier = Modifier.width(with(LocalDensity.current){viewWidth.value.width.toDp()}),
            expanded = isExpanded.value, onDismissRequest = toggle) {
            items.forEach { DropMenuItem(it) { item -> selectAndDismiss(item) } }
        }
    }
}

@Composable
private fun DropMenuItem(label: String, selectionListener: (String) -> Unit) {
    DropdownMenuItem(onClick = {
        selectionListener(label)
    }) {
        Text(text = label)
    }
}
