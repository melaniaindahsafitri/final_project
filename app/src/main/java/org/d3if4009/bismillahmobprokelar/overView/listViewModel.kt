package org.d3if4009.bismillahmobprokelar.overView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.d3if4009.bismillahmobprokelar.network.BuahApiService
import org.d3if4009.bismillahmobprokelar.network.BuahProperty
import java.lang.Exception

class listViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
    get() = _response

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _properties = MutableLiveData<List<BuahProperty>>()
    val properties: LiveData<List<BuahProperty>>
    get() = _properties

    init {
        getDataBuah()
    }

    private fun getDataBuah(){
        coroutineScope.launch {
            var getPropertiesDeffered = BuahApiService.BuahApi.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeffered.await()
                _response.value = "Success: ${listResult.size} Fruit properties retrieved"
                if (listResult.size>0){
                    _properties.value = listResult
                }
            }catch (e: Exception){
                _response.value = "Failed: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}