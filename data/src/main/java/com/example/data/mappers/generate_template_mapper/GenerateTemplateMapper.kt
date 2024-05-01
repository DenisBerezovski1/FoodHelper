package com.example.data.mappers.generate_template_mapper

import com.example.data.db.current_plan.*
import com.example.data.models.generate_template.GenerateMealsResponse
import com.example.data.models.generate_template.NutrientsTemplateResponse
import javax.inject.Inject

class GenerateTemplateMapper @Inject constructor() {

    fun toMondayEntity(elements: List<GenerateMealsResponse>): List<MondayCurrentEntity> {
        return elements.map {
            MondayCurrentEntity(
                id = it.id ?: 0,
                title = it.title ?: "",
                readyInMinutes = it.readyInMinutes ?: 0,
                servings = it.servings ?: 0,
                sourceUrl = it.sourceUrl ?: "",
                imageType = it.imageType ?: ""
            )
        }
    }

    fun toTuesdayEntity(elements: List<GenerateMealsResponse>): List<TuesdayCurrentEntity> {
        return elements.map {
            TuesdayCurrentEntity(
                id = it.id ?: 0,
                title = it.title ?: "",
                readyInMinutes = it.readyInMinutes ?: 0,
                servings = it.servings ?: 0,
                sourceUrl = it.sourceUrl ?: "",
                imageType = it.imageType ?: ""
            )
        }
    }

    fun toWednesdayEntity(elements: List<GenerateMealsResponse>): List<WednesdayCurrentEntity> {
        return elements.map {
            WednesdayCurrentEntity(
                id = it.id ?: 0,
                title = it.title ?: "",
                readyInMinutes = it.readyInMinutes ?: 0,
                servings = it.servings ?: 0,
                sourceUrl = it.sourceUrl ?: "",
                imageType = it.imageType ?: ""
            )
        }
    }

    fun toThursdayEntity(elements: List<GenerateMealsResponse>): List<ThursdayCurrentEntity> {
        return elements.map {
            ThursdayCurrentEntity(
                id = it.id ?: 0,
                title = it.title ?: "",
                readyInMinutes = it.readyInMinutes ?: 0,
                servings = it.servings ?: 0,
                sourceUrl = it.sourceUrl ?: "",
                imageType = it.imageType ?: ""
            )
        }
    }

    fun toFridayEntity(elements: List<GenerateMealsResponse>): List<FridayCurrentEntity> {
        return elements.map {
            FridayCurrentEntity(
                id = it.id ?: 0,
                title = it.title ?: "",
                readyInMinutes = it.readyInMinutes ?: 0,
                servings = it.servings ?: 0,
                sourceUrl = it.sourceUrl ?: "",
                imageType = it.imageType ?: ""
            )
        }
    }

    fun toSaturdayEntity(elements: List<GenerateMealsResponse>): List<SaturdayCurrentEntity> {
        return elements.map {
            SaturdayCurrentEntity(
                id = it.id ?: 0,
                title = it.title ?: "",
                readyInMinutes = it.readyInMinutes ?: 0,
                servings = it.servings ?: 0,
                sourceUrl = it.sourceUrl ?: "",
                imageType = it.imageType ?: ""
            )
        }
    }

    fun toSundayEntity(elements: List<GenerateMealsResponse>): List<SundayCurrentEntity> {
        return elements.map {
            SundayCurrentEntity(
                id = it.id ?: 0,
                title = it.title ?: "",
                readyInMinutes = it.readyInMinutes ?: 0,
                servings = it.servings ?: 0,
                sourceUrl = it.sourceUrl ?: "",
                imageType = it.imageType ?: ""
            )
        }
    }

    fun toNutrientsEntity(elements: NutrientsTemplateResponse): NutrientsCurrentEntity {
        return NutrientsCurrentEntity(
            calories = elements.calories ?: 0.0,
            carbohydrates = elements.carbohydrates ?: 0.0,
            fat = elements.fat ?: 0.0,
            protein = elements.protein ?: 0.0
        )
    }
}