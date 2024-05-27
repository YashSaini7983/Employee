package com.example.employee

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

         val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(EmployeeInterface::class.java)

        val responseLiveData : LiveData<Response<EmployeeDataBase>> =

            liveData {
                val response = retrofitInstance.getDetail()
                emit(response)
            }

        responseLiveData.observe(this, Observer { response ->
            if (response.isSuccessful) {
                val employeeList = response.body()
                if (employeeList != null) {
                    recyclerView = findViewById(R.id.recyclerView)
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.adapter = EmployeeAdapter(employeeList)
                } else {
                    Toast.makeText(this, "Employee list is null", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
            }
        })














    }
}