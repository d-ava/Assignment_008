package com.example.assignment_008

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_008.model.Cources
import com.example.breakingbad.network.NetworkClient
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private val _cources = MutableSharedFlow<Cources>()
    val cources :SharedFlow<Cources> = _cources

fun loadCources(){
    viewModelScope.launch {
        withContext(IO){
            val response = NetworkClient.api.getCources()
            val body = response.body()
            if(response.isSuccessful && body != null){
                _cources.emit(body)
            }
        }
    }
}



}