package com.example.connectingtointernet.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connectingtointernet.Repository
import com.example.connectingtointernet.api.Info
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) :ViewModel(){
    private val TAG = MainViewModel::class.java.simpleName
    private val _infoLiveData =MutableLiveData<List<Info>>()
    val infoLiveData:LiveData<List<Info>>
    get() = _infoLiveData

    init {
        getInfo()
    }

    private fun getInfo(){
        viewModelScope.launch {
            try {
                _infoLiveData.value = repository.getInfo("2").info
                Log.d(TAG,"${_infoLiveData.value}")
            } catch (e:Exception){
                Log.e(TAG, e.message.toString())
            }

        }

    }


}