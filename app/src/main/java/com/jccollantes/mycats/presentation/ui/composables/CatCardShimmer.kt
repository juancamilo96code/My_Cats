package com.jccollantes.mycats.presentation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip


@Composable
fun CatCardShimmer(modifier: Modifier) {
    Spacer(
        modifier = modifier
            .clip(RoundedCornerShape(20f))
            .background(buildDefaultShimmerBrush())
    )
}

