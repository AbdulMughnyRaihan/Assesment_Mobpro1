package com.d3if0114.MyKalkulatorCinta.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "input")
data class InputEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var nama: String,
    var namaPasangan: String
)