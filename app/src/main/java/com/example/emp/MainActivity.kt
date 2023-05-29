package com.example.emp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), EmpItemClickListener
{
    private lateinit var binding: ActivityMainBinding

    private val empViewModel: EmpViewModel by viewModels {
        EmpItemModelFactory((application as EmpApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.newEmpButton.setOnClickListener {
            NewEmpSheet(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView()
    {
        val mainActivity = this

        empViewModel.empItems.observe(this){


            binding.empListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = EmpItemAdapter(it, mainActivity)
            }
        }
    }

    override fun editEmpItem(empItem: EmpItem)
    {
        NewEmpSheet(empItem).show(supportFragmentManager,"newEmpTag")
    }

    override fun deleteEmpItem(empItem: EmpItem) {
        empViewModel.deleteEmpItem(empItem)
    }

}







