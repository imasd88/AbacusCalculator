package com.emazdoor.abacuscalculator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.emazdoor.abacuscalculator.BR
import android.R
import com.emazdoor.abacuscalculator.databinding.ItemNumbersBinding
import com.emazdoor.abacuscalculator.model.CalcModel


class InputAdapter(val context: Context, val block: (number: Int) -> Unit) :
    RecyclerView.Adapter<InputAdapter.ViewHolder>() {

    var list: List<CalcModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class ViewHolder(private val binding: ItemNumbersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(numbersModel: CalcModel) {
            binding.apply {
                setVariable(BR.numbers, numbersModel)
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputAdapter.ViewHolder {
        return ViewHolder(
            ItemNumbersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InputAdapter.ViewHolder, position: Int) {
        holder.apply {
            val item = list[position]
            bind(item)

            val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
            animation.startOffset = (30 * position).toLong()
            itemView.startAnimation(animation)

            itemView.setOnClickListener {
                block(item.numbers)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}