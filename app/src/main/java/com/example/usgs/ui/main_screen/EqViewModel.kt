package com.example.usgs.ui.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usgs.domain.EqRepository
import com.example.usgs.domain.models.Eq
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EqViewModel @Inject constructor(
    private val repository: EqRepository
) : ViewModel() {

    private val _eq = MutableLiveData<List<Eq>>()
    val eq: LiveData<List<Eq>>
        get() =  _eq

    init {
        refreshAllEq()
    }

    fun refreshAllEq() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getEqList()
            _eq.postValue(list)
        }
    }
}