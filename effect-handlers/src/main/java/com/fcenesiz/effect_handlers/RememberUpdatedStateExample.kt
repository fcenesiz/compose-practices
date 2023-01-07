package com.fcenesiz.effect_handlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun ContentRememberUpdateState(
    onTimeOut: () -> Unit
) {
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(3000L)
        updatedOnTimeout
    }
}