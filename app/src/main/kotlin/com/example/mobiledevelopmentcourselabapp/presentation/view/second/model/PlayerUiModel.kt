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
) : ItemUiModel

enum class Position(val rusName: String = "") {
    BACHELOR("Бакалавр"),
    SPECIALIST("Специалист"),
    MASTER("Магистрант"),
    POSTGRADUATE("Аспирант")
}

object AdUiModel : ItemUiModel