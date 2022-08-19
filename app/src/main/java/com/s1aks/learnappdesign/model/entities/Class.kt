package com.s1aks.learnappdesign.model.entities

data class Class(
    val type: ClassType,
    val iconString: String,
    val name: String,
    val timePeriod: String,
    val teacher: String,
    val description: String,
    val showInWeb: Boolean,
    val skypeUri: String,
    val users: List<String>? = null
) {
    enum class ClassType {
        STANDARD, ADDITIONAL
    }
}