package org.d3if4009.bismillahmobprokelar.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/melaniaindahsafitri/gambar-buah/gambar-buah/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface BuahApiService{

    @GET("fruit.json")

    fun getProperties(): Deferred<List<BuahProperty>>

    object BuahApi{
        val retrofitService : BuahApiService by lazy {
            retrofit.create(BuahApiService::class.java)
        }
    }
    }
