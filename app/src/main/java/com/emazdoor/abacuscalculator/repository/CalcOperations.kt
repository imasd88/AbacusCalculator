package com.emazdoor.abacuscalculator.repository

interface CalcOperations {
    fun add(param1: Int, vararg param2: Int): Int
    fun subtract(param1: Int, vararg param2: Int): Int
    fun multiply(param1: Int, vararg param2: Int): Int
    fun divide(param1: Int, param2: Int): Double
    fun remainder(param1: Int, vararg param2: Int): Double
    fun split(param1: Int, param2: Int): List<Int>
}