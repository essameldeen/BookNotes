package com.coderboot.compose_ui_components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class NavigationDrawerView {

    data class DrawerAction(var icon: ImageVector, var text: String, var action: () -> Unit)

    private var header: @Composable () -> Unit = {}

    private val actions = mutableListOf<DrawerAction>()

    fun addHeader(header: @Composable () -> Unit): NavigationDrawerView {
        this@NavigationDrawerView.header = header
        return this@NavigationDrawerView
    }

    fun addAction(action: DrawerAction): NavigationDrawerView {
        actions.add(action)
        return this@NavigationDrawerView
    }

    @Composable
    fun Build() = NavigationDrawer()

    @Composable
    private fun NavigationDrawer() {
        LazyColumn(
            modifier = Modifier.fillMaxHeight()
        ) {
            item { header() }
            items(actions) { action ->
                NavigationDrawerAction(action.icon, action.text, action.action)
            }
        }
    }

    @Composable
    private fun NavigationDrawerHeader() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

        }
    }

    @Composable
    private fun NavigationDrawerAction(icon: ImageVector, label: String, action: () -> Unit) {
        TextButton(onClick = { action() }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 24.dp)
            ) {
                Icon(icon, contentDescription = "", modifier = Modifier.size(24.dp), tint = Color.DarkGray)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = label, fontSize = 18.sp, color = Color.DarkGray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationDrawerPreview() = NavigationDrawerView().Build()