package com.emazdoor.abacuscalculator.repository

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculationRepositoryTest {

    lateinit var calculationRepository: CalculationRepository
    private val DELTA = 1e-15

    @Before
    fun setUp() {
        calculationRepository = CalculationRepository()
    }

    @Test
    fun add() {
        assertEquals(18, calculationRepository.add(5, 2, 3, 5, 3))
    }

    @Test
    fun subtract() {
        assertEquals(12, calculationRepository.subtract(25, 2, 3, 5, 3))
    }

    @Test
    fun multiply() {
        assertEquals(120, calculationRepository.multiply(2, 4, 3, 5))
    }

    @Test
    fun divide() {
        assertEquals(4.0, calculationRepository.divide(16, 4), DELTA)
    }

    @Test
    fun remainder() {
        assertEquals(5.0, calculationRepository.remainder(140, 45, 35, 20), DELTA)
    }

    @Test
    fun split() {
        assertEquals("[30, 30, 30, 30]", calculationRepository.split(120, 4).toString())
    }
}