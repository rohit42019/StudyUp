package com.example.studyup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar

class CourseActivity : AppCompatActivity() {
    lateinit var courseImage : ImageView
    lateinit var courseName : TextView
    lateinit var coursePrice : TextView
    lateinit var courseInstructor : TextView
    lateinit var courseDescription : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        val courseObject = intent.getSerializableExtra("CourseDetails") as Course

        courseImage = findViewById(R.id.course_image_id)
        courseName = findViewById(R.id.course_name_id)
        coursePrice = findViewById(R.id.course_price_id)
        courseInstructor = findViewById(R.id.course_instructors_id)
        courseDescription = findViewById(R.id.course_description_id)

        courseImage.setImageResource(courseObject.getCourseImageResourceId())
        courseName.text = courseObject.getCourseName()
        coursePrice.text = courseObject.getStartingPrice()
        var arr = courseObject.getCourseInstructorNames()
        courseInstructor.text = arr[0]
        for(i in 1 until arr.size)
        {
            courseInstructor.text = courseInstructor.text.toString() + " , " + arr[i]
        }

        courseDescription.text = courseObject.getCourseDescription()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            android.R.id.home -> {finish()
                return true}
            else -> {false }
        }
    }
}