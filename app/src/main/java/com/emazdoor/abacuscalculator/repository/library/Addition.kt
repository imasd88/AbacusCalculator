package com.emazdoor.abacuscalculator.repository.library

import com.emazdoor.abacuscalculator.repository.library.interfaces.Operations

class Addition : Operations<Int> {
    override fun executeOperation(value1: Int, vararg value2: Int): Int {
        var result = value1
        for (element in value2)
            result += element
        return result
    }
}