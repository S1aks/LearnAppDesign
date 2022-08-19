package com.s1aks.learnappdesign.model.entities

data class Homework(
    val iconString: String,
    val name: String,
    val timeLeft: String,
    val description: String,
    val users: List<String>
)
