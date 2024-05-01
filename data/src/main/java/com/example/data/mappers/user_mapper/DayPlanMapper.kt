package com.example.data.mappers.user_mapper

import com.example.data.db.current_plan.NutrientsCurrentEntity
import com.example.data.db.meal_plans.*
import com.example.domain.models.generate_template.NutrientsTemplateData
import com.example.domain.models.user.DayPlanData
import javax.inject.Inject

class DayPlanMapper @Inject constructor() {
    fun fromMonday(elements: List<MondayEntity>): List<DayPlanData> {
        return elements.map {
            DayPlanData(
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun fromTuesday(elements: List<TuesdayEntity>): List<DayPlanData> {
        return elements.map {
            DayPlanData(
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun fromWednesday(elements: List<WednesdayEntity>): List<DayPlanData> {
        return elements.map {
            DayPlanData(
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun fromThursday(elements: List<ThursdayEntity>): List<DayPlanData> {
        return elements.map {
            DayPlanData(
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun fromFriday(elements: List<FridayEntity>): List<DayPlanData> {
        return elements.map {
            DayPlanData(
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun fromSaturday(elements: List<SaturdayEntity>): List<DayPlanData> {
        return elements.map {
            DayPlanData(
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun fromSunday(elements: List<SundayEntity>): List<DayPlanData> {
        return elements.map {
            DayPlanData(
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun nutrientsMapper(nutrientsCurrentEntity: NutrientsPlanEntity): NutrientsTemplateData {
        return NutrientsTemplateData(
            calories = nutrientsCurrentEntity.calories,
            carbohydrates = nutrientsCurrentEntity.carbohydrates,
            fat = nutrientsCurrentEntity.fat,
            protein = nutrientsCurrentEntity.protein
        )
    }

}