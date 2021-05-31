package com.example.studyup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CourseCategoryAdapter : RecyclerView.Adapter<CourseCategoryAdapter.CourseCategoryViewHolder>{
    var cContext : Context
    var dataset: ArrayList<CourseCategory>
    constructor(cContext : Context, dataset : ArrayList<CourseCategory>)
    {
        this.cContext = cContext
        this.dataset = dataset
    }
    class CourseCategoryViewHolder : RecyclerView.ViewHolder
    {
        var categoryTextView : TextView
        var categoryRecyclerView : RecyclerView

        constructor(itemview : View) : super(itemview)
        {
            categoryTextView = itemview.findViewById(R.id.course_category_name_id)
            categoryRecyclerView = itemview.findViewById(R.id.course_item_recycler_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseCategoryViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.courses_category_item,parent,false)
        return(CourseCategoryViewHolder(itemview))
    }

    override fun onBindViewHolder(holder: CourseCategoryViewHolder, position: Int) {
        holder.categoryTextView.text = dataset.get(position).getCourseCategoryName()
        onBind(holder,position)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
    public fun onBind(holder : CourseCategoryViewHolder, position: Int)
    {
        val adapter = CourseItemAdapter(cContext,dataset.get(position).getCourseList())
        holder.categoryRecyclerView.layoutManager = LinearLayoutManager(cContext,RecyclerView.HORIZONTAL,false)
        holder.categoryRecyclerView.adapter = adapter
    }
}