package com.emazdoor.abacuscalculator.repository.library.interfaces

interface Operations<T> {
    fun executeOperation(value1: Int, value2: IntArray): T
}