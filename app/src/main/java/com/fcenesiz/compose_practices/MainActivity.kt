package com.fcenesiz.compose_practices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fcenesiz.compose_practices.ui.theme.ComposePracticesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .border(2.dp, Color.Magenta)
                    .padding(16.dp)
                    .border(2.dp, Color.Green)
                    .padding(16.dp)
                    .border(4.dp, Color.Yellow)
                    .padding(8.dp)
            ) {
                Text(
                    "Hello", modifier = Modifier
                        .border(5.dp, Color.Red)
                        .padding(10.dp)
                        .clickable { }
                )
                Spacer(modifier = Modifier.height(50.dp))
                Text("World")
            }
        }
    }
}

