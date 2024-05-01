package com.example.data.mappers.generate_template_mapper

import com.example.data.db.current_plan.*
import com.example.domain.models.generate_template.GenerateMealsData
import com.example.domain.models.generate_template.NutrientsTemplateData
import javax.inject.Inject

class TemplateEntityMapper @Inject constructor() {

    fun mondayMealsMapper(elements: List<MondayCurrentEntity>): List<GenerateMealsData> {
        return elements.map {
            GenerateMealsData(
                id = it.id,
                title = it.title ,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType
            )
        }
    }

    fun tuesdayMealsMapper(elements: List<TuesdayCurrentEntity>): List<GenerateMealsData> {
        return elements.map {
            GenerateMealsData(
                id = it.id,
                title = it.title ,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType
            )
        }
    }

    fun wednesdayMealsMapper(elements: List<WednesdayCurrentEntity>): List<GenerateMealsData> {
        return elements.map {
            GenerateMealsData(
                id = it.id,
                title = it.title ,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType
            )
        }
    }

    fun thursdayMealsMapper(elements: List<ThursdayCurrentEntity>): List<GenerateMealsData> {
        return elements.map {
            GenerateMealsData(
                id = it.id,
                title = it.title ,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType
            )
        }
    }

    fun fridayMealsMapper(elements: List<FridayCurrentEntity>): List<GenerateMealsData> {
        return elements.map {
            GenerateMealsData(
                id = it.id,
                title = it.title ,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType
            )
        }
    }

    fun saturdayMealsMapper(elements: List<SaturdayCurrentEntity>): List<GenerateMealsData> {
        return elements.map {
            GenerateMealsData(
                id = it.id,
                title = it.title ,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType
            )
        }
    }

    fun sundayMealsMapper(elements: List<SundayCurrentEntity>): List<GenerateMealsData> {
        return elements.map {
            GenerateMealsData(
                id = it.id,
                title = it.title ,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType
            )
        }
    }

    fun nutrientsMapper(nutrientsCurrentEntity: NutrientsCurrentEntity): NutrientsTemplateData {
        return NutrientsTemplateData(
            calories = nutrientsCurrentEntity.calories,
            carbohydrates = nutrientsCurrentEntity.carbohydrates,
            fat = nutrientsCurrentEntity.fat,
            protein = nutrientsCurrentEntity.protein
        )
    }
}