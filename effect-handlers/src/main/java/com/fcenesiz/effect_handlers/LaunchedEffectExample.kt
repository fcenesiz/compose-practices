package com.fcenesiz.effect_handlers

import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun ContentLaunchedEffect() {
    var text by remember {
        mutableStateOf("")
    }
    LaunchedEffect(key1 = text) {
        delay(1000L)
        println("The text is $text")
    }
}