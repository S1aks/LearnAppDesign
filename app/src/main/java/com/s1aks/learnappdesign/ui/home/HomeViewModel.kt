package com.s1aks.learnappdesign.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.s1aks.learnappdesign.model.MockData
import com.s1aks.learnappdesign.model.entities.Class
import com.s1aks.learnappdesign.model.entities.Homework

class HomeViewModel : ViewModel() {

    var classData = MutableLiveData<List<Class>>()
        private set
    var homeworkData = MutableLiveData<List<Homework>>()
        private set

    fun getClasses() {
        classData.value = MockData.classes
    }

    fun getHomeworks() {
        homeworkData.value = MockData.homeworks
    }
}