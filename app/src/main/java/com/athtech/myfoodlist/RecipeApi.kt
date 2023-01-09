package com.athtech.myfoodlist

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import android.util.Log

private const val BASE_URL = "https://api.edamam.com/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()


interface RecipeApi {

    @GET("api/recipes/v2?type=public&app_id=35c1cec6&app_key=f4935cc752ee45964a64cea6fb3c1681&cuisineType=British")
    fun getAllData(): Call<List<Data>>


}

object Api {
    val retrofitService: RecipeApi by lazy { retrofit.create(RecipeApi::class.java) }
}