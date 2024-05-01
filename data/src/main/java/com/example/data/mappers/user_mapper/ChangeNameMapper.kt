package com.example.data.mappers.user_mapper

import com.example.data.db.meal_plans.*
import javax.inject.Inject

class ChangeNameMapper @Inject constructor() {
    fun changeMondayPlan(elements: List<MondayEntity>, name: String): List<MondayEntity> {
        return elements.map {
            MondayEntity(
                plan = name,
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun changeTuesdayPlan(elements: List<TuesdayEntity>, name: String): List<TuesdayEntity> {
        return elements.map {
            TuesdayEntity(
                plan = name,
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun changeWednesdayPlan(elements: List<WednesdayEntity>, name: String): List<WednesdayEntity> {
        return elements.map {
            WednesdayEntity(
                plan = name,
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun changeThursdayPlan(elements: List<ThursdayEntity>, name: String): List<ThursdayEntity> {
        return elements.map {
            ThursdayEntity(
                plan = name,
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun changeFridayPlan(elements: List<FridayEntity>, name: String): List<FridayEntity> {
        return elements.map {
            FridayEntity(
                plan = name,
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun changeSaturdayPlan(elements: List<SaturdayEntity>, name: String): List<SaturdayEntity> {
        return elements.map {
            SaturdayEntity(
                plan = name,
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun changeSundayPlan(elements: List<SundayEntity>, name: String): List<SundayEntity> {
        return elements.map {
            SundayEntity(
                plan = name,
                id = it.id,
                title = it.title,
                readyInMinutes = it.readyInMinutes,
                servings = it.servings,
                sourceUrl = it.sourceUrl,
                imageType = it.imageType,
            )
        }
    }

    fun changeNutrientsPlan(elements: List<NutrientsPlanEntity>, name: String): List<NutrientsPlanEntity> {
        return elements.map {
            NutrientsPlanEntity(
                plan = name,
                calories = it.calories,
                carbohydrates = it.carbohydrates,
                fat = it.fat,
                protein = it.protein
            )
        }
    }

}