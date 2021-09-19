package com.emazdoor.abacuscalculator.ui

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.emazdoor.abacuscalculator.repository.OperationType
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityViewModelTest: TestCase() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    public override fun setUp() {
        super.setUp()
        mainActivityViewModel = MainActivityViewModel()
    }

    @Test
    fun calculate_Add() {
        assertEquals("18", mainActivityViewModel.calculate("5+2+3+5+3", OperationType.ADD))
    }

    @Test
    fun calculate_subtract() {
        assertEquals("12", mainActivityViewModel.calculate("25-2-3-5-3", OperationType.SUBTRACT))
    }

    @Test
    fun calculate_division() {
        assertEquals("4.0", mainActivityViewModel.calculate("16/4", OperationType.DIVISION))
    }

    @Test
    fun calculate_multiplication() {
        assertEquals("120", mainActivityViewModel.calculate("2*4*3*5", OperationType.MULTIPLY))
    }

    @Test
    fun calculate_remainder() {
        assertEquals("5.0", mainActivityViewModel.calculate("140 Rem 45 Rem 35 Rem 20", OperationType.REMAINDER))
    }

    @Test
    fun calculate_split() {
        assertEquals("[30, 30, 30, 30]", mainActivityViewModel.calculate("120 SE 4", OperationType.SPLIT))
    }

    @Test
    fun calculate_undefined() {
       assertEquals("Single operation per calculation supported", mainActivityViewModel.calculate("120 SE 4", OperationType.UNDEFINED))
    }
}