package com.example.adv160420029week4.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420029week4.R
import com.example.adv160420029week4.model.Student
import com.example.adv160420029week4.util.loadImage

class StudentListAdapter (val studenList:ArrayList<Student>)
:RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }


    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val txtIDSL = holder.view.findViewById<TextView>(R.id.txtIDSL)
        val txtNameSL = holder.view.findViewById<TextView>(R.id.txtNameSL)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)

        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(studenList[position].photoUrl, progressBar)

        txtIDSL.text = studenList[position].id
        txtNameSL.text = studenList[position].name

        btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail(studenList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return studenList.size
    }
}