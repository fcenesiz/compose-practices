package com.fcenesiz.effect_handlers

import android.annotation.SuppressLint
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@SuppressLint("UnrememberedMutableState")
@Composable
fun ContentDerivedStateOf() {
    var counter by remember {
        mutableStateOf(0)
    }
    val counterText by derivedStateOf {
        "The counter is $counter"
    }
    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}