package com.s1aks.learnappdesign.model

import com.s1aks.learnappdesign.R
import com.s1aks.learnappdesign.model.entities.Class
import com.s1aks.learnappdesign.model.entities.Homework

object MockData {
    val classes = listOf(
        Class(
            Class.ClassType.STANDARD, "\uD83C\uDFF9", "History",
            "8:00 - 8:45", "Mrs Thomas", "", true,
            "skype:echo123?call"
        ),
        Class(
            Class.ClassType.STANDARD, "\uD83D\uDCDA", "Literature",
            "9:00 - 9:45", "Mrs Barros", "", false, ""
        ),
        Class(
            Class.ClassType.ADDITIONAL, "\uD83C\uDFC0", "Physical Education",
            "10:00 - 11:35", "Mrs Barros",
            "Intensive preparation for The Junior World Championship in Los Angeles",
            false, "", listOf("⛹️", "⛹️", "⛹️")
        ),
        Class(
            Class.ClassType.STANDARD, "\uD83E\uDDEA", "Chemistry",
            "12:00 - 12:45", "Mr White", "", false, ""
        ),
        Class(
            Class.ClassType.STANDARD, "\uD83D\uDD28", "Physics",
            "13:00 - 13:45", "Mr Jenkins", "", true,
            "skype:echo123?call"
        ),
        Class(
            Class.ClassType.STANDARD, "\uD83D\uDD2D", "Astronomy",
            "14:00 - 14:45", "Mrs Pinkman", "", false, ""
        ),
    )

    val homeworks = listOf(
        Homework(
            "\uD83D\uDCDA", "Literature",
            "2 days left", "Read scenes 1.1-1.12 of The Master and Margarita",
            listOf("\uD83E\uDDD1", "\uD83D\uDC69")
        ),
        Homework(
            "\uD83D\uDD28", "Physics",
            "5 days left", "Learn Newton's law for objects motion",
            listOf("\uD83E\uDDD1\u200D\uD83D\uDCBB", "\uD83D\uDC69")
        ),
        Homework(
            "\uD83E\uDDEA", "Chemistry",
            "6 days left", "Find picture of molecules water (H20)",
            listOf("\uD83E\uDDD1", "\uD83D\uDC69")
        ),
    )

    val usersColorMap = mapOf(
        "\uD83E\uDDD1" to R.drawable.shape_oval_users_yellow,
        "\uD83D\uDC69" to R.drawable.shape_oval_users_blue,
        "\uD83E\uDDD1\u200D\uD83D\uDCBB" to R.drawable.shape_oval_users_green,
    )
}