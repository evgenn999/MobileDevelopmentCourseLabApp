package com.example.mobiledevelopmentcourselabapp.presentation.view.second.generator

import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.StudentUiModel
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.Position
import com.github.javafaker.Faker

object Generator {
    private const val STUDENTS_COUNT = 100
    private const val PHOTO_LINK = "https://img.a.transfermarkt.technology/portrait/medium/"
    private val photos = arrayOf(
        "290532-1686212081.jpg",
        "709726-1672304545.jpg",
        "315252-1605116025.png",
        "748319-1694617058.jpg"
    )

    fun generate(): List<StudentUiModel> {
        val faker = Faker()
        return mutableListOf<StudentUiModel>().apply {
            repeat(STUDENTS_COUNT) {
                add(
                    StudentUiModel(
                        name = faker.name().fullName(),
                        team = faker.team().name(),
                        number = (1..25).random(),
                        age = (18..35).random(),
                        position = Position.values().random(),
                        photoUrl = PHOTO_LINK + photos.random(),
                        fiveGrade = (1..9).random(),
                        fourGrade = (1..9).random(),
                        threeGrade = (1..9).random(),
                        oneGrade = (1..9).random(),
                        twoGrade = (1..9).random()
                    )
                )
                //if (Random.nextBoolean()) add(AdUiModel)
            }
        }
    }
}