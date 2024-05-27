package com.example.employee

import com.google.gson.annotations.SerializedName

data class Employee(

    @SerializedName("id")
    val id : Int ,
    @SerializedName("employee_name")
    val employee_name : String ,
     @SerializedName("employee_salary")
    val employee_salary : Int ,
    @SerializedName("employee_age ")
    val employee_age : Int



)
