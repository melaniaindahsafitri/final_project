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

enum class buahApiStatus { LOADING, ERROR, DONE }

class ListViewModel : ViewModel() {

    private val _status = MutableLiveData<buahApiStatus>()
    val status: LiveData<buahApiStatus>
    get() = _status

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _properties = MutableLiveData<List<BuahProperty>>()
    val properties: LiveData<List<BuahProperty>>
    get() = _properties

    private val _navigateToSelectedItem = MutableLiveData<BuahProperty>()
    val navigateToSelectedItem : LiveData<BuahProperty>
    get() = _navigateToSelectedItem

    init {
        getDataBuah()
    }

    private fun getDataBuah(){
        coroutineScope.launch {
            var getPropertiesDeffered = BuahApiService.BuahApi.retrofitService.getProperties()
            try {
                _status.value = buahApiStatus.LOADING
                var listResult = getPropertiesDeffered.await()
                _status.value = buahApiStatus.DONE
                if(listResult.size > 0){
                    _properties.value = listResult
                }
            }catch (e: Exception){
                _status.value = buahApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun displayItemDetails(BuahProperty: BuahProperty){
        _navigateToSelectedItem.value = BuahProperty
    }

    fun displayItemDetailsComplete(){
        _navigateToSelectedItem.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}