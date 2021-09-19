package com.emazdoor.abacuscalculator.repository

enum class OperationType(val value: String) {
    UNDEFINED("-1"),
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVISION("/"),
    REMAINDER(" Rem "),
    SPLIT(" SE ")
}