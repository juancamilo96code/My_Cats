package com.jccollantes.mycats.presentation.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jccollantes.mycats.data.model.Cat
import com.jccollantes.mycats.data.model.Resource
import com.jccollantes.mycats.domain.usescase.GetCatsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeCatsViewModel @Inject constructor(
    private val getCatsListUseCase: GetCatsListUseCase
) : ViewModel() {

    private val _catsList = MutableLiveData<Resource<List<Cat?>?>>()
    val catsList: LiveData<Resource<List<Cat?>?>> = _catsList

    init {
        loadData()
    }

    private fun loadData() {
        getCatsList()
    }

    private fun getCatsList() {
        viewModelScope.launch {
            _catsList.value = Resource.Loading()
            _catsList.value = getCatsListUseCase()
        }
    }
}
