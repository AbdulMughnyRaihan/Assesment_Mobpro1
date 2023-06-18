package com.d3if0114.MyKalkulatorCinta.ui.Pasangan

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.d3if0114.MyKalkulatorCinta.model.Pasangan
import com.d3if0114.MyKalkulatorCinta.network.ApiStatus
import com.d3if0114.MyKalkulatorCinta.network.ServiceAPI
import com.d3if0114.MyKalkulatorCinta.network.UpdateWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class PasanganViewModel : ViewModel() {
    private val data = MutableLiveData<List<Pasangan>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(ServiceAPI.pasanganService.getPasangan())
                status.postValue(ApiStatus.SUCCES)
            } catch (e: Exception) {
                Log.d("SukuViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Pasangan>> = data

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }

    fun getStatus(): LiveData<ApiStatus> = status
}