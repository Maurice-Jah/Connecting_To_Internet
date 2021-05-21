package com.example.connectingtointernet.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.connectingtointernet.Repository

class MainViewModeFactory(private val repository: Repository):ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(MainViewModel::class.java)){
           return MainViewModel(repository) as T
       } else{
           throw IllegalArgumentException("UNKNOWN CLASS")
       }
    }
}