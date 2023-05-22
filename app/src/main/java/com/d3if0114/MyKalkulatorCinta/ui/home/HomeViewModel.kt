package com.d3if0114.MyKalkulatorCinta.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if0114.MyKalkulatorCinta.db.InputDao
import com.d3if0114.MyKalkulatorCinta.db.InputEntity
import com.d3if0114.MyKalkulatorCinta.model.Output
import com.d3if0114.MyKalkulatorCinta.model.generateHasil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val db: InputDao): ViewModel() {
    private val hasil = MutableLiveData<Output?>()

    fun generateHasil(nama: String, namaPasangan: String) {
        val dataHasil = InputEntity(
            nama = nama,
            namaPasangan = namaPasangan
        )
        hasil.value = dataHasil.generateHasil()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataHasil)
            }
        }
    }

    fun getHasil(): LiveData<Output?> = hasil
}