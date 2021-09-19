package com.emazdoor.abacuscalculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emazdoor.abacuscalculator.R
import com.emazdoor.abacuscalculator.repository.CalculationRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculationRepository = CalculationRepository()

        println(calculationRepository.divide(16, 4))

    }
}