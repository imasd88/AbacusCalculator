package com.emazdoor.abacuscalculator.repository

interface Operations<T> {
    fun executeOperation(value1: Int, vararg value2: Int): T
}