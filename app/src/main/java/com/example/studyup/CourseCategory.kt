package com.example.studyup

class CourseCategory {
    private var courseCategoryName : String
    private var courseList : ArrayList<Course>
    constructor(courseCategoryName: String, courseList : ArrayList<Course>)
    {
        this.courseCategoryName = courseCategoryName
        this.courseList = courseList
    }
    public fun getCourseCategoryName() : String
    {
        return courseCategoryName
    }
    public fun setCourseCategoryName(courseCategoryName: String)
    {
        this.courseCategoryName = courseCategoryName
    }
    public fun getCourseList() : ArrayList<Course>
    {
        return courseList
    }
    public fun setCourseList(courseList: ArrayList<Course>)
    {
        this.courseList = courseList
    }
}