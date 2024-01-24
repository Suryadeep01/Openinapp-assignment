package com.example.openinapp.HomeViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openinapp.OpenInModel.Data
import com.example.openinapp.OpenInModel.TopLinks
import com.example.openinapp.api.BaseUrl
import com.example.openinapp.api.Service
import kotlinx.coroutines.launch
import okhttp3.internal.wait

class HomeViewModel():ViewModel(){
    val topLinks: MutableLiveData<TopLinks> = MutableLiveData()

    fun getApiLink() = viewModelScope.launch {
        val service = BaseUrl.getInstance().create(Service::class.java)
        val link = service.getLink()
        topLinks.value = link.body()
    }

}