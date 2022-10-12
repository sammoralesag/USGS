package com.example.usgs.ui.details_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usgs.domain.EqRepository
import com.example.usgs.domain.models.Eq
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: EqRepository
) : ViewModel() {
    private val _eq = MutableLiveData<List<Eq>>()
    val eq: LiveData<List<Eq>>
        get() = _eq
}