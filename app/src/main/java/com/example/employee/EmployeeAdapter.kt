package com.example.employee


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val employeeList :ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(item)
    }

    override fun getItemCount(): Int {
       return employeeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = employeeList[position]
        holder.rvId.text = currentItem.id.toString()
        holder.rvName.text = currentItem.employee_name
        holder.rvAge.text = currentItem.employee_age.toString()
        holder.rvSalary.text = currentItem.employee_salary.toString()

    }



    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)
    {
        val rvId = itemView.findViewById<TextView>(R.id.txtId)
        val rvName = itemView.findViewById<TextView>(R.id.txtName)
        val rvSalary = itemView.findViewById<TextView>(R.id.txtSalary)
        val rvAge = itemView.findViewById<TextView>(R.id.txtAge)
    }

}