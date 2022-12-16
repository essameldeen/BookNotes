package com.coderboot.compose_ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class BottomNavigationView {

    data class Screen(var icon: ImageVector, var nav: String, var screen: @Composable (String) -> Unit)

    private val screens = mutableListOf<Screen>()

    fun addScreen(screen: Screen): BottomNavigationView {
        screens.add(screen)
        return this@BottomNavigationView
    }

    @Composable
    fun Build() = BottomNavigationScreen()

    @Composable
    private fun BottomNavigationScreen() {
        val navAction = remember { mutableStateOf(0) }
        val screen = screens[navAction.value]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            verticalArrangement = Arrangement.Bottom
        ) {
            Surface(Modifier.weight(1f)) {
                screen.screen(screen.nav)
            }
            BottomNavigation(
                modifier = Modifier.height(75.dp),
                elevation = 7.dp
            ) {
                for (i in screens.indices) {
                    NavigationAction(icon = screens[i].icon, title = screens[i].nav, i == navAction.value) { navAction.value = i }
                }
            }
        }
    }

    @Composable
    private fun NavigationAction(icon: ImageVector, title: String, selected: Boolean, action: () -> Unit = {}) {
        Column(
            modifier = Modifier
                .clickable { action() }
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(icon, contentDescription = "", tint = if (selected) Color.White else Color.LightGray)
            Spacer(modifier = Modifier.width(6.dp))
            Text(title, color = if (selected) Color.White else Color.LightGray)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() = BottomNavigationView().Build()