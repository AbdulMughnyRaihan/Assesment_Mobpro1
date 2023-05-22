package com.d3if0114.MyKalkulatorCinta.model

import com.d3if0114.MyKalkulatorCinta.db.InputEntity

fun InputEntity.generateHasil(): Output {
    // TODO
    val nama = nama
    val namaPasangan = namaPasangan
    val randomNumber = (0..100).random()
    fun hasil(): String {
        return nama + " dan " + namaPasangan + " : " + randomNumber + "% Kalian adalah Jodoh!"
    }

    val hasilText = hasil()

    return Output(nama, namaPasangan, hasilText)
}