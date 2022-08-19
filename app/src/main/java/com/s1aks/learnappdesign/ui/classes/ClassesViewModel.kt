package com.s1aks.learnappdesign.ui.classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.s1aks.learnappdesign.model.MockData
import com.s1aks.learnappdesign.model.entities.Class

class ClassesViewModel : ViewModel() {

    var classData = MutableLiveData<List<Class>>()
        private set

    fun getClasses() {
        classData.value = MockData.classes
    }
}