package com.emazdoor.abacuscalculator.ui

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.emazdoor.abacuscalculator.R
import com.emazdoor.abacuscalculator.adapter.InputAdapter
import com.emazdoor.abacuscalculator.databinding.ActivityMainBinding
import com.emazdoor.abacuscalculator.model.CalcModel
import com.emazdoor.abacuscalculator.repository.OperationType

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private val inputAdapter = InputAdapter(this) { number -> setInput(number) }

    var operationType = OperationType.UNDEFINED

    private lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }

        binding.rvHome.apply {
            adapter = inputAdapter
            layoutManager = GridLayoutManager(context, 2)
        }

        animation = AnimationUtils.loadAnimation(this@MainActivity, android.R.anim.slide_in_left)
    }

    override fun onResume() {
        super.onResume()
        populateCalcView()
        binding.apply {
            clear.setOnClickListener(this@MainActivity)
            add.setOnClickListener(this@MainActivity)
            add.setOnClickListener(this@MainActivity)
            subtract.setOnClickListener(this@MainActivity)
            multiply.setOnClickListener(this@MainActivity)
            divide.setOnClickListener(this@MainActivity)
            remainder.setOnClickListener(this@MainActivity)
            split.setOnClickListener(this@MainActivity)
            equal.setOnClickListener(this@MainActivity)

            //prevent input from keyboard
            input.showSoftInputOnFocus = false;

            //animation
            buttonContainer.startAnimation(animation)
        }
    }

    private fun populateCalcView() {
        val calcList = arrayListOf<CalcModel>()
        for (i in 1..9)
            calcList.add(CalcModel(numbers = i))
        calcList.add(CalcModel(0))
        inputAdapter.list = calcList.toList()
    }

    private fun setInput(number: Int) {
        val input = viewModel.mutableLiveExpression.value + number
        viewModel.mutableLiveExpression.postValue(input)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.clear -> {
                viewModel.mutableLiveExpression.postValue("")
                viewModel.mutableLiveResult.postValue("Results")
            }
            R.id.add -> {
                val input = viewModel.mutableLiveExpression.value + OperationType.ADD.value
                operationType = OperationType.ADD
                viewModel.mutableLiveExpression.postValue(input)
            }
            R.id.subtract -> {
                val input = viewModel.mutableLiveExpression.value + OperationType.SUBTRACT.value
                operationType = OperationType.SUBTRACT
                viewModel.mutableLiveExpression.postValue(input)
            }
            R.id.multiply -> {
                val input = viewModel.mutableLiveExpression.value + OperationType.MULTIPLY.value
                operationType = OperationType.MULTIPLY
                viewModel.mutableLiveExpression.postValue(input)
            }
            R.id.divide -> {
                val input = viewModel.mutableLiveExpression.value + OperationType.DIVISION.value
                operationType = OperationType.DIVISION
                viewModel.mutableLiveExpression.postValue(input)
            }
            R.id.remainder -> {
                val input = viewModel.mutableLiveExpression.value + OperationType.REMAINDER.value
                operationType = OperationType.REMAINDER
                viewModel.mutableLiveExpression.postValue(input)
            }
            R.id.split -> {
                val input = viewModel.mutableLiveExpression.value + OperationType.SPLIT.value
                operationType = OperationType.SPLIT
                viewModel.mutableLiveExpression.postValue(input)
            }
            R.id.equal -> {
                val input = viewModel.mutableLiveExpression.value
                viewModel.mutableLiveResult.postValue(
                    viewModel.calculate(
                        input = input!!,
                        operationType
                    )
                )
                viewModel.mutableLiveExpression.postValue("")

                animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.scale_in)
                binding.result.startAnimation(animation)

                if (operationType == OperationType.SPLIT || operationType == OperationType.DIVISION)
                    Toast.makeText(
                        this,
                        "Only first two values will be calculated",
                        Toast.LENGTH_LONG
                    ).show()
            }

        }

    }

}