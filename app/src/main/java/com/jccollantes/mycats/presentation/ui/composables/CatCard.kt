package com.jccollantes.mycats.presentation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jccollantes.mycats.data.model.Cat
import coil.compose.rememberAsyncImagePainter
import com.jccollantes.mycats.R
import com.jccollantes.mycats.utils.JPG

@Composable
fun CatCard(cat: Cat?, modifier: Modifier) {
    cat?.let {
        Box(modifier = modifier.border(1.dp, Color.Black)) {

            cat.breedName?.let { it1 ->
                Text(
                    text = it1,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.TopCenter)
                )
            }
            Image(
                painter = rememberAsyncImagePainter(
                    model = stringResource(
                        id = R.string.image_url
                    ) + cat.imageUrl + JPG
                ),
                contentScale = ContentScale.FillWidth,
                contentDescription = cat.breedName,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 26.dp, 0.dp, 60.dp)
            )
            Column(modifier = Modifier.align(Alignment.BottomStart)) {

                Text(
                    text = "origin = " + cat.origin.toString(),
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(2.dp)
                )
                Text(
                    text = "intelligence = " + cat.intelligence.toString(),
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(2.dp)
                )
                Text(
                    text = "affection level = " + cat.affectionLevel.toString(),
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(2.dp)
                )
            }
        }
    }
}