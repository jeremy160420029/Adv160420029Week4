package com.example.adv160420029week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adv160420029week4.model.Student

class DetailViewModel: ViewModel()  {
    val studentDD = MutableLiveData<Student>()

    fun fetch(detailStudent: String) {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778",
            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")

        val student2 =
            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff")

        val student3 =
            Student("11204","Dinny","1994/10/07","6827808747","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")

        if(detailStudent == student1.id){
            studentDD.value = student1
        } else if(detailStudent == student2.id){
            studentDD.value = student2
        } else if(detailStudent == student3.id){
            studentDD.value = student3
        }
    }
}