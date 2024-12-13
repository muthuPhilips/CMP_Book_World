package com.philips.bookworld

import androidx.compose.ui.window.ComposeUIViewController
import com.philips.bookworld.app.App
import com.philips.bookworld.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }