package com.rdpsoftware.myappointments.io

import com.rdpsoftware.myappointments.Models.Doctor
import com.rdpsoftware.myappointments.Models.Schedule
import com.rdpsoftware.myappointments.Models.Specialty
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("specialties")
    abstract fun getSpecialties():Call<ArrayList<Specialty>>

    @GET("specialties/{specialty}/doctors")
    abstract fun getDoctors(@Path("specialty") specialtyId: Int):Call<ArrayList<Doctor>>

    @GET("schedule/hours")
    abstract fun getHours(@Query("doctor_id") doctor_id: Int, @Query("date") date: String):Call<Schedule>

    companion object Factory{
        private const val BASE_URL = "http://104.236.89.149/api/"

        fun create(): ApiService{
           val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

          val retrofit = Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .client(client)
                  .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}