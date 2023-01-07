package com.fcenesiz.compose_practices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ContentConstraintLayoutExample() {
    ConstraintExample03()
}

@Composable
fun ConstraintExample01() {
    val constraints = ConstraintSet {
        val yellowBox = createRefFor("yellowBox")
        val redBox = createRefFor("redBox")

        constrain(yellowBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(yellowBox.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
    }
    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .layoutId("yellowBox")
            .background(Color.Yellow))
        Box(modifier = Modifier
            .layoutId("redBox")
            .background(Color.Red))
    }
}

@Composable
fun ConstraintExample02() {
    val constraints = ConstraintSet {
        val yellowBox = createRefFor("yellowBox")
        val redBox = createRefFor("redBox")

        constrain(yellowBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(yellowBox.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(
            yellowBox,
            redBox,
            chainStyle = ChainStyle.Packed
        )
    }
    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .layoutId("yellowBox")
            .background(Color.Yellow))
        Box(modifier = Modifier
            .layoutId("redBox")
            .background(Color.Red))
    }
}

@Composable
fun ConstraintExample03() {
    val constraints = ConstraintSet {
        val yellowBox = createRefFor("yellowBox")
        val redBox = createRefFor("redBox")
        val guideline = createGuidelineFromTop(0.5f)

        constrain(yellowBox) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(yellowBox.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(
            yellowBox,
            redBox,
            chainStyle = ChainStyle.Packed
        )
    }
    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .layoutId("yellowBox")
            .background(Color.Yellow))
        Box(modifier = Modifier
            .layoutId("redBox")
            .background(Color.Red))
    }
}