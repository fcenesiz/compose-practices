package com.fcenesiz.effect_handlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
fun ContentSideEffect(nonComposeCounter: Int) {
    SideEffect {
        println("Called after every successful recomposition")
    }
}