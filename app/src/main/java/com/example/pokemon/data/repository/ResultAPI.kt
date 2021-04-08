package com.example.pokemon.data.repository



interface ResultAPI<T> {

    fun onSuccess(value: T)
}