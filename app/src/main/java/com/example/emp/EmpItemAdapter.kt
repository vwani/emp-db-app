package com.example.emp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emp.databinding.EmpItemCellBinding


class EmpItemAdapter(
    private val empItems: List<EmpItem>,
    private val clickListener: EmpItemClickListener
    ): RecyclerView.Adapter<EmpItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpItemViewHolder {
        val from = LayoutInflater.from(parent.context)

        val binding = EmpItemCellBinding.inflate(from, parent, false)
        return EmpItemViewHolder(parent.context, binding, clickListener)
    }


    override fun onBindViewHolder(holder: EmpItemViewHolder, position: Int) {
        holder.bindEmpItem(empItems[position])
    }

    override fun getItemCount(): Int = empItems.size
}


