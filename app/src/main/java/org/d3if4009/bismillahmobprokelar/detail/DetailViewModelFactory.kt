package org.d3if4009.bismillahmobprokelar.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4009.bismillahmobprokelar.network.BuahProperty
import java.lang.IllegalArgumentException

class DetailViewModelFactory (
    private val BuahProperty: BuahProperty,
    private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return  DetailViewModel(BuahProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}