package com.emazdoor.abacuscalculator.repository

import android.util.Log
import com.emazdoor.abacuscalculator.repository.library.*
import com.emazdoor.abacuscalculator.repository.library.interfaces.Operations

class CalculationRepository : CalcOperations {

    override fun add(param1: Int, vararg param2: Int): Int {
        val addition: Operations<Int> = Addition()
        return addition.executeOperation(param1, param2)
    }

    override fun subtract(param1: Int, vararg param2: Int): Int {
        val subtraction: Operations<Int> = Subtraction()
        return subtraction.executeOperation(param1, param2)
    }

    override fun multiply(param1: Int, vararg param2: Int): Int {
        val multiplication: Operations<Int> = Multiplication()
        return multiplication.executeOperation(param1, param2)
    }

    override fun divide(param1: Int, param2: Int): Double {
        val division: Operations<Double> = Division()
        return division.executeOperation(param1, intArrayOf(param2))
    }

    override fun remainder(param1: Int, vararg param2: Int): Double {
        val remainder: Operations<Double> = Remainder()
        return remainder.executeOperation(param1, param2)
    }

    override fun split(param1: Int, param2: Int): List<Int> {
        val doubleArrayOperation: Operations<List<Int>> = Split()
        try {
            return doubleArrayOperation.executeOperation(param1, intArrayOf(param2))
        } catch (e: Exception) {
            Log.e("ASD", "Second value is not entered or more than two values entered")
        }
        return arrayListOf()
    }
}