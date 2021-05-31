package com.example.studyup

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CourseItemAdapter(var cContext : Context, var dataset : ArrayList<Course>) : RecyclerView.Adapter<CourseItemAdapter.CourseItemViewHolder>() {
    class CourseItemViewHolder : RecyclerView.ViewHolder
    {
        var courseItemImageView : ImageView
        var courseItemNameTextView  : TextView
        var courseItemPriceTextView : TextView
        var courseItemExploreButton : Button
        constructor(itemview : View) : super(itemview)
        {
            courseItemImageView = itemview.findViewById(R.id.course_item_image_id)
            courseItemNameTextView = itemview.findViewById(R.id.course_item_name_id)
            courseItemPriceTextView = itemview.findViewById(R.id.starting_price_id)
            courseItemExploreButton = itemview.findViewById(R.id.explore_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseItemAdapter.CourseItemViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.course_item_layout,parent,false)
        return(CourseItemViewHolder(itemview))
    }

    override fun onBindViewHolder(holder: CourseItemAdapter.CourseItemViewHolder, position: Int) {
        val obj = dataset.get(position)
        holder.courseItemImageView.setImageResource(obj.getCourseImageResourceId())
        holder.courseItemNameTextView.text = obj.getCourseName()
        holder.courseItemPriceTextView.text = obj.getStartingPrice()
        holder.courseItemExploreButton.setOnClickListener {
            //Moving to CourseActivity
            val intent = Intent(cContext,CourseActivity::class.java)
            intent.putExtra("CourseDetails",obj)
            cContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}