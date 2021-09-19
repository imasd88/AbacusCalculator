package com.emazdoor.abacuscalculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.emazdoor.abacuscalculator.R
import com.emazdoor.abacuscalculator.adapter.InputAdapter
import com.emazdoor.abacuscalculator.databinding.ActivityMainBinding
import com.emazdoor.abacuscalculator.model.CalcModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val viewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private val inputAdapter = InputAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.also {
            it.lifecycleOwner = this
        }

        binding.rvHome.apply {
            adapter = inputAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun onResume() {
        super.onResume()
        val calcList = arrayListOf<CalcModel>()
        for (i in 0..9)
            calcList.add(CalcModel(numbers = i))
        inputAdapter.list = calcList.toList()
    }
}