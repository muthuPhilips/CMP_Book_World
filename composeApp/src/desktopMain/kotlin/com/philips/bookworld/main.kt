package com.philips.bookworld

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.philips.bookworld.app.App
import com.philips.bookworld.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookworld",
        ) {
            App()
        }
    }
}