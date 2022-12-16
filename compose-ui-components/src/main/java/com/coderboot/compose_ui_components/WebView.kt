package com.coderboot.compose_ui_components

import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.coderboot.compose_ui_components.theme.PrimaryColor

@Composable
fun WebView(url: String = "", padding: PaddingValues) {
    AndroidView(modifier = Modifier.fillMaxSize().padding(padding).background(color = PrimaryColor), factory = {
        android.webkit.WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(url)
        }
    })
}