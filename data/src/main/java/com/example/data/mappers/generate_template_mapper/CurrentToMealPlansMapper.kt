package com.example.data.mappers.generate_template_mapper

import com.example.data.db.current_plan.*
import com.example.data.db.meal_plans.*
import com.example.data.models.generate_template.GenerateMealsResponse
import com.example.data.models.generate_template.NutrientsTemplateResponse
import javax.inject.Inject

class CurrentToMealPlansMapper @Inject constructor() {
    fun toMondayEntity(elements: List<MondayCurrentEntity>, plan: String): List<MondayEntity> {
        return elements.map {
            MondayEntity(
                id = it.id,
                plan = plan,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun toTuesdayEntity(elements: List<TuesdayCurrentEntity>, plan: String): List<TuesdayEntity> {
        return elements.map {
            TuesdayEntity(
                id = it.id,
                plan = plan,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun toWednesdayEntity(elements: List<WednesdayCurrentEntity>, plan: String): List<WednesdayEntity> {
        return elements.map {
            WednesdayEntity(
                id = it.id,
                plan = plan,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun toThursdayEntity(elements: List<ThursdayCurrentEntity>, plan: String): List<ThursdayEntity> {
        return elements.map {
            ThursdayEntity(
                id = it.id,
                plan = plan,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun toFridayEntity(elements: List<FridayCurrentEntity>, plan: String): List<FridayEntity> {
        return elements.map {
            FridayEntity(
                id = it.id,
                plan = plan,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun toSaturdayEntity(elements: List<SaturdayCurrentEntity>, plan: String): List<SaturdayEntity> {
        return elements.map {
            SaturdayEntity(
                id = it.id,
                plan = plan,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun toSundayEntity(elements: List<SundayCurrentEntity>, plan: String): List<SundayEntity> {
        return elements.map {
            SundayEntity(
                id = it.id,
                plan = plan,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun toNutrientsEntity(elements: NutrientsCurrentEntity, plan: String): NutrientsPlanEntity {
        return NutrientsPlanEntity(
            plan = plan,
            calories = elements.calories,
            carbohydrates = elements.carbohydrates,
            fat = elements.fat,
            protein = elements.protein
        )
    }
}