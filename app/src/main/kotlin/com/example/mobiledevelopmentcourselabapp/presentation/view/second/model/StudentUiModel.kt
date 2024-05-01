package com.example.mobiledevelopmentcourselabapp.presentation.view.second.model

import java.io.Serializable

interface ItemUiModel : Serializable
data class StudentUiModel(
    val name: String,
    val photoUrl: String,
    val number: Int,
    val team: String,
    val position: Position,
    val age: Int,
    val fiveGrade: Int,
    val fourGrade: Int,
    val threeGrade: Int,
    val twoGrade: Int,
    val oneGrade: Int,
    var isExpanded: Boolean = false
) : ItemUiModel {
    val formattedFiveGrade = "Кол-во 5: $fiveGrade"
    val formattedFourGrade = "Кол-во 4: $fourGrade"
    val formattedThreeGrade = "Кол-во 3: $threeGrade"
    val formattedTwoGrade = "Кол-во 2: $twoGrade"
    val formattedOneGrade = "Кол-во 1: $oneGrade"
}

enum class Position(val rusName: String = "") {
    BACHELOR("Бакалавр"),
    SPECIALIST("Специалист"),
    MASTER("Магистрант"),
    POSTGRADUATE("Аспирант")
}

object AdUiModel : ItemUiModel