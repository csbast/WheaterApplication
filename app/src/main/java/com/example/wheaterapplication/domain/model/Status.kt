package com.example.wheaterapplication.domain.model

sealed class Status<out T> {
    class Succes<T>(val response: T) : Status<T>()
    class Error(val responseErros: String) : Status<Nothing>()
}