package com.example.employee

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance  {

    companion object
    {
        val mainurl = "http://dummy.restapiexample.com/"


        fun getRetrofitInstance() : Retrofit
        {
            return Retrofit.Builder()
            .baseUrl(mainurl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
        }


    }



}