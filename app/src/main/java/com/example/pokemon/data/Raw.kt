package com.example.pokemon.data

interface Raw<SafeType> {
    fun asSafe() : SafeType
}