package com.emazdoor.abacuscalculator.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emazdoor.abacuscalculator.repository.CalculationRepository
import com.emazdoor.abacuscalculator.repository.OperationType

class MainActivityViewModel : ViewModel() {

    private val calculationRepository = CalculationRepository()

    val mutableLiveExpression = MutableLiveData<String>()
    val mutableLiveResult = MutableLiveData<String>()

    init {
        mutableLiveExpression.postValue("")
        mutableLiveResult.postValue("Results")
    }

    fun calculate(input: String, operationType: OperationType): String {
        var value1: String = "0"
        val value2: ArrayList<Int> = arrayListOf()
        val splitValues = input.split(operationType.value).toTypedArray()
        value1 = splitValues[0]

        for (element in splitValues.drop(1)) {
            if (element.isNotEmpty())
                value2.add(element = element.toInt())

        }
        try {
            return when (operationType) {
                OperationType.ADD -> {
                    calculationRepository.add(value1.toInt(), *value2.toIntArray()).toString()
                }
                OperationType.SUBTRACT -> {
                    calculationRepository.subtract(value1.toInt(), *value2.toIntArray()).toString()
                }
                OperationType.MULTIPLY -> {
                    calculationRepository.multiply(value1.toInt(), *value2.toIntArray()).toString()
                }
                OperationType.DIVISION -> {
                    calculationRepository.divide(value1.toInt(), value2[0]).toString()
                }
                OperationType.SPLIT -> {
                    calculationRepository.split(value1.toInt(), value2[0]).toString()
                }
                OperationType.REMAINDER -> {
                    calculationRepository.remainder(value1.toInt(), *value2.toIntArray()).toString()
                }
                OperationType.UNDEFINED -> {
                    throw UnsupportedOperationException()
                }
            }
        } catch (e: Exception) {
            return "Single operation per calculation supported"
        }
    }
}