package com.example.employee

import retrofit2.Response
import retrofit2.http.GET

interface EmployeeInterface {

    @GET("/employees")

    suspend fun getDetail() : Response<EmployeeDataBase>


}