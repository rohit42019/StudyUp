package com.example.studyup

import java.io.Serializable

class Course : Serializable{
    private var courseImageResourceId : Int
    private var courseName : String
    private var startingPrice : String
    private var courseInstructorNames : ArrayList<String>
    private var courseDescription : String
    constructor(courseImageResourceId : Int, courseName : String, startingPrice : String,courseInstructorNames : ArrayList<String>,courseDescription : String)
    {
        this.courseImageResourceId = courseImageResourceId
        this.courseName = courseName
        this.startingPrice = startingPrice
        this.courseInstructorNames = courseInstructorNames
        this.courseDescription = courseDescription
    }
    public fun getCourseImageResourceId() : Int{
        return courseImageResourceId
    }
    public fun setCourseImageResourceId(courseImageResourceId: Int)
    {
        this.courseImageResourceId = courseImageResourceId
    }
    public fun getCourseName() : String
    {
        return courseName
    }
    public fun setCourseName(courseName: String)
    {
        this.courseName = courseName
    }
    public fun getStartingPrice() : String
    {
        return startingPrice
    }
    public fun setStartingPrice(startingPrice: String)
    {
        this.startingPrice = startingPrice
    }
    public fun getCourseInstructorNames() : ArrayList<String>
    {
        return courseInstructorNames
    }
    public fun setCourseInstructorNames(courseInstructorNames: ArrayList<String>)
    {
        this.courseInstructorNames = courseInstructorNames
    }
    public fun getCourseDescription() : String
    {
        return courseDescription
    }
    public fun setCourseDescription(courseDescription: String)
    {
        this.courseDescription = courseDescription
    }


}