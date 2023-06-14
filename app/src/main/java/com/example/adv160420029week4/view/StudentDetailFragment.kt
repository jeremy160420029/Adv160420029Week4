package com.example.adv160420029week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420029week4.R
import com.example.adv160420029week4.databinding.FragmentStudentDetailBinding
import com.example.adv160420029week4.util.loadImage
import com.example.adv160420029week4.util.showNotification
import com.example.adv160420029week4.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment(), ButtonNotif, ButtonUpdate {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding:FragmentStudentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var detailStudent = ""
        if(arguments != null){
            detailStudent = StudentDetailFragmentArgs.fromBundle(requireArguments()).detail
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(detailStudent)

//        val txtIDSL = view.findViewById<TextView>(R.id.txtIDSL)
//        val txtName = view.findViewById<TextView>(R.id.txtName)
//        val txtBod = view.findViewById<TextView>(R.id.txtBod)
//        val txtPhone = view.findViewById<TextView>(R.id.txtPhone)
//        var imageView = view.findViewById<ImageView>(R.id.imageView2)
//        var progressBar = view.findViewById<ProgressBar>(R.id.progressBar2)
//        var btnNotif = view.findViewById<Button>(R.id.btnNotif)

        observeViewModel()
        dataBinding.notif = this
        dataBinding.update = this
    }

    fun observeViewModel() {
        viewModel.studentsDD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
//            var studentList = it
//            txtIDSL.text = studentList.id
//            txtNameSL.text = studentList.name
//            txtBod.text = studentList.bod
//            txtPhone.text = studentList.phone
//
//            imageView.loadImage(studentList.photoUrl, progressBar)

//            var student = it
//            btnNotif.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds")
//                        showNotification(studentList.name.toString(),
//                            "A new notification created",
//                            R.drawable.baseline_circle_notifications_24)
//                    }
//            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StudentDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StudentDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onButtonNotif(v: View) {
        Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("Messages", "five seconds")
                        showNotification(v.tag.toString(),
                            "A new notification created",
                            R.drawable.baseline_circle_notifications_24)
                    }
    }

    override fun onButtonUpdate(v: View) {
        TODO("Not yet implemented")
    }
}