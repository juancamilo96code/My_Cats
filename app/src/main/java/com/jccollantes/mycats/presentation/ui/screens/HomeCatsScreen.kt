package com.jccollantes.mycats.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.jccollantes.mycats.data.model.Resource
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jccollantes.mycats.R
import com.jccollantes.mycats.data.model.Cat
import com.jccollantes.mycats.presentation.ui.composables.CatsCarrouselList
import com.jccollantes.mycats.presentation.ui.composables.Title

@Composable
fun HomeCatsScreen(
    homeCatsViewModel: HomeCatsViewModel
) {

    val catsList: Resource<List<Cat?>?> by homeCatsViewModel.catsList.observeAsState(
        initial = Resource.Sleep()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .align(
                    Alignment.CenterHorizontally
                )
        ) {
            Title(
                stringResource(id = R.string.name),
                Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            )
        }

        if (catsList !is Resource.GenericDataError) {
            CatsCarrouselList(
                orientation = LocalConfiguration.current.orientation,
                isLoading = catsList is Resource.Loading,
                catsList = catsList.data,
                modifier = Modifier
            )
        }
    }
}