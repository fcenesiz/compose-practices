package com.fcenesiz.compose_practices

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContentBottomSheetExample() {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy
        )
    )
    val sheetPeekHigh = remember {
        mutableStateOf(BottomSheetScaffoldDefaults.SheetPeekHeight)
    }
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(300.dp)
                    .background(Color.Green)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Bottom sheet", fontSize = 60.sp)
            }
        },
        sheetBackgroundColor = Color.Yellow,
        sheetPeekHeight = sheetPeekHigh.value
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(onClick = {
                    scope.launch {
                        if (sheetState.isCollapsed)
                            sheetState.expand()
                        else
                            sheetState.collapse()
                    }
                }) {
                    Text(text = "Toggle Sheet")
                }
                Button(onClick = {
                    scope.launch {
                        if (sheetState.isCollapsed)
                            sheetState.expand()
                        else
                            sheetState.collapse()
                    }
                }) {
                    Text(text = "Bottom sheet fraction: ${sheetState.progress.fraction}")
                }
                Button(onClick = {
                    scope.launch {
                        if (sheetPeekHigh.value > 0.dp)
                            sheetPeekHigh.value = 0.dp
                        else
                            sheetPeekHigh.value = BottomSheetScaffoldDefaults.SheetPeekHeight
                    }
                }) {
                    Text(text = "Bottom sheet visible: ${sheetPeekHigh.value}")
                }
            }

        }
    }
}