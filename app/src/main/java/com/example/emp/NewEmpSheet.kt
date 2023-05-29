package com.example.emp

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.emp.databinding.FragmentNewEmpSheetBinding

class NewEmpSheet(var empItem: EmpItem?) : BottomSheetDialogFragment()
{

    private lateinit var binding: FragmentNewEmpSheetBinding
    private lateinit var empViewModel: EmpViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (empItem != null)
        {

            binding.empTitle.text = "Edit Info"
            val editable = Editable.Factory.getInstance()

            binding.id.text = editable.newEditable(empItem!!.id.toString())
            binding.name.text = editable.newEditable(empItem!!.name)
            binding.dept.text = editable.newEditable(empItem!!.dept)
            binding.sal.text = editable.newEditable(empItem!!.sal.toString())


        }
        else
        {
            binding.empTitle.text = "New Employee"
        }

        empViewModel = ViewModelProvider(activity).get(EmpViewModel::class.java)

        binding.saveButton.setOnClickListener {
            saveAction()
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewEmpSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


    private fun saveAction()
    {
        val id = binding.id.text.toString().toInt()
        val name = binding.name.text.toString()
        val dept = binding.dept.text.toString()
        val sal = binding.sal.text.toString().toInt()

        if(empItem == null)
        {

            val newEmp = EmpItem(id, name, dept, sal)
            empViewModel.addEmpItem(newEmp)
        }
        else
        {
            empItem!!.id = id
            empItem!!.name = name
            empItem!!.dept = dept
            empItem!!.sal = sal

            empViewModel.updateEmpItem(empItem!!)
        }

        binding.id.setText("")
        binding.name.setText("")
        binding.dept.setText("")
        binding.sal.setText("")

        dismiss()
    }

}








