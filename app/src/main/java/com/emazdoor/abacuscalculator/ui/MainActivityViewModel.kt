package com.emazdoor.abacuscalculator.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val mutableLiveExpression = MutableLiveData<String>()
    val liveExpression: LiveData<String>
        get() = mutableLiveExpression

}