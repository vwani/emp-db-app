package com.example.emp

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.emp.databinding.EmpItemCellBinding
import java.time.format.DateTimeFormatter

class EmpItemViewHolder(
    private val context: Context,
    private val binding: EmpItemCellBinding,
    private val clickListener: EmpItemClickListener
): RecyclerView.ViewHolder(binding.root)
{

    fun bindEmpItem(empItem: EmpItem)
    {
        binding.id.text = "ID: " + empItem.id.toString()
        binding.name.text = "Name: " + empItem.name
        binding.dept.text = "Department: " + empItem.dept
        binding.sal.text = "Salary: " + empItem.sal.toString()

        binding.empCellContainer.setOnClickListener{
            clickListener.editEmpItem(empItem)
        }

        binding.btnDel.setOnClickListener{
            clickListener.deleteEmpItem(empItem)
        }

    }
}