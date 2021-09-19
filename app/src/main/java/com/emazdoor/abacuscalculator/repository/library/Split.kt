package com.emazdoor.abacuscalculator.repository.library

import com.emazdoor.abacuscalculator.repository.library.interfaces.Operations

class Split : Operations<List<Int>> {
    override fun executeOperation(value1: Int, vararg value2: Int): List<Int> {
        if (value2.size > 1 || value2.isEmpty()) {
            throw UnsupportedOperationException()
        }
        val resultArr = arrayListOf<Int>()
        val value2Element = value2[0]
        val result = value1 / value2Element
        for (i in 0 until value2Element) {
            resultArr.add(result)
        }
        return resultArr
    }
}