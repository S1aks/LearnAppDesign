package com.s1aks.learnappdesign.di

import com.s1aks.learnappdesign.ui.classes.ClassesViewModel
import com.s1aks.learnappdesign.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel() }
    viewModel { ClassesViewModel() }
}