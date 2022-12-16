package com.coderboot.compose_ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.TabRow
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

class ViewPager {

    data class Page(var icon: ImageVector, var tab: String, var page: @Composable (String) -> Unit)

    private val pages = mutableListOf<Page>()

    fun addPage(page: Page): ViewPager {
        pages.add(page)
        return this@ViewPager
    }

    @Composable
    fun Build() = PagerScreen()

    @Composable
    private fun PagerScreen() {
        val tab = remember { mutableStateOf(0) }
        val page = pages[tab.value]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            TabRow(selectedTabIndex = tab.value) {
                for (i in pages.indices) {
                    Tab(icon = pages[i].icon, title = pages[i].tab) { tab.value = i }
                }
            }
            page.page(page.tab)
        }
    }

    @Composable
    private fun Tab(icon: ImageVector, title: String, action: () -> Unit = {}) {
        Row(
            modifier = Modifier
                .clickable { action() }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(icon, contentDescription = "")
            Spacer(modifier = Modifier.width(6.dp))
            Text(title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PagerPreview() = ViewPager().Build()