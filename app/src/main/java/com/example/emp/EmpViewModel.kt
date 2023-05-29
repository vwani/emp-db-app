package com.example.emp

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class EmpViewModel(private val repository: EmpItemRepository): ViewModel()
{
    val empItems: LiveData<List<EmpItem>> = repository.allEmpItems.asLiveData()

    fun addEmpItem(empItem: EmpItem) = viewModelScope.launch {
        repository.insertEmpItem(empItem)
    }


    fun updateEmpItem(empItem: EmpItem) = viewModelScope.launch {
        repository.updateEmpItem(empItem)
    }

    fun deleteEmpItem(empItem: EmpItem) = viewModelScope.launch {
        repository.deleteEmpItem(empItem)
    }

}

class EmpItemModelFactory(private val repository: EmpItemRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(EmpViewModel::class.java))
            return EmpViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}