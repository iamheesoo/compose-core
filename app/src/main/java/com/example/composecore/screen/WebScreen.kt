package com.example.composecore.screen

import android.app.Activity
import android.util.Log
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun WebScreen() {
    val settingUrl = "https://www.google.com"
//    val header = hashMapOf("Authorization" to BuildConfig.AUTHORIZATION)

    val webViewState = rememberWebViewState(
        url = settingUrl,
//        additionalHttpHeaders = header
    )
    var webView: WebView? = null

    WebView(
        state = webViewState,
        captureBackPresses = true,
        onCreated = {
            it.settings.run {
                javaScriptEnabled = true
                domStorageEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
                setSupportMultipleWindows(false)
                javaScriptCanOpenWindowsAutomatically = false
                cacheMode = WebSettings.LOAD_NO_CACHE
            }
//            it.addJavascriptInterface(PostScript(), "PostScript")
            webView = it
        },
        client = AccompanistWebViewClient(),
        chromeClient = AccompanistWebChromeClient(),
    )

    val activity = LocalContext.current as? Activity

    BackHandler(enabled = true) {
        if (webView?.canGoBack() == true) {
            webView?.goBack()
        } else {
            activity?.finish()
        }
    }
}

@Composable
fun MyWebView(webUrl: String, header: HashMap<String, String>) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()

            settings.run {
                javaScriptEnabled = true
                domStorageEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
                setSupportMultipleWindows(false)
                javaScriptCanOpenWindowsAutomatically = false
                cacheMode = WebSettings.LOAD_NO_CACHE
            }

            loadUrl(webUrl, header)
        }
    })
}


class PostScript {

    @JavascriptInterface
    fun eventJavaScriptHandler(type: String, value: String) {
        Log.i("!!!", "type: $type value: $value")
    }
}