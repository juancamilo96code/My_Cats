package com.jccollantes.mycats.presentation.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jccollantes.mycats.data.model.Cat

@Composable
fun CatsCarrouselList(
    orientation: Int,
    isLoading: Boolean,
    catsList: List<Cat?>?,
    modifier: Modifier
) {


    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        Box(modifier = modifier.padding(24.dp, 0.dp, 0.dp, 24.dp)) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier) {
                val modifierItem = Modifier
                    .width(215.dp)
                    .fillMaxHeight()
                if (!isLoading) {
                    if (catsList != null) {
                        items(catsList) {
                            CatCard(cat = it, modifier = modifierItem)
                        }
                    }
                } else {
                    items(listOf(1, 1, 1, 1, 1, 1)) {
                        CatCardShimmer(modifier = modifierItem)
                    }
                }
            }
        }
    } else {
        Box(modifier = modifier.padding(24.dp, 0.dp, 24.dp, 0.dp)) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                val modifierItem = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                if (!isLoading) {
                    if (catsList != null) {
                        items(catsList) {
                            CatCard(cat = it, modifier = modifierItem)
                        }
                    }
                } else {
                    items(listOf(1, 1, 1)) {
                        CatCardShimmer(modifier = modifierItem)
                    }
                }
            }
        }
    }

}