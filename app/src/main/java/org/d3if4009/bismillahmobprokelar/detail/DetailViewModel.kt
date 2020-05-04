package org.d3if4009.bismillahmobprokelar.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.d3if4009.bismillahmobprokelar.network.BuahProperty

class DetailViewModel (BuahProperty: BuahProperty,
                       app: Application) : AndroidViewModel(app) {
    private val _selectedItem = MutableLiveData<BuahProperty>()
    val selectedItem: LiveData<BuahProperty>
        get() = _selectedItem

    init {
        _selectedItem.value = BuahProperty
    }
}