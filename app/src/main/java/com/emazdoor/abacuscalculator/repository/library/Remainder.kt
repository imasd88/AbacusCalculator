package com.emazdoor.abacuscalculator.repository.library

import com.emazdoor.abacuscalculator.repository.library.interfaces.Operations

class Remainder : Operations<Double> {
    override fun executeOperation(value1: Int, vararg value2: Int): Double {
        //Ahmed: revisit this again
        var result = value1.toDouble()
        for (element in value2)
            result %= element
        return result
    }
}