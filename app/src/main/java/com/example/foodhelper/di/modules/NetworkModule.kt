package com.example.foodhelper.di.modules

import com.example.data.network.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun getFoodService(retrofit: Retrofit): FoodService = retrofit.create(FoodService::class.java)

    @Provides
    @Singleton
    fun getInstructionsService(retrofit: Retrofit): AnalyzedInstructionService =
        retrofit.create(AnalyzedInstructionService::class.java)

    @Provides
    @Singleton
    fun getGenerateTemplateService(retrofit: Retrofit): GenerateTemplateService =
        retrofit.create(GenerateTemplateService::class.java)

    @Provides
    @Singleton
    fun getOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }
}