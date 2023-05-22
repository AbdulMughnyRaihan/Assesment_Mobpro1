package com.d3if0114.MyKalkulatorCinta.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if0114.MyKalkulatorCinta.db.InputDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoriViewModel(private val db: InputDao) : ViewModel() {
    val data = db.getLastQuotes()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}