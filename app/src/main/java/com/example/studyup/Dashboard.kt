package com.example.studyup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class Dashboard : AppCompatActivity() {
    lateinit var courseCategoryRecycler : RecyclerView
    lateinit var courseCategoryList : ArrayList<CourseCategory>
    lateinit var username : TextView
    lateinit var description : String
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    companion object{
        const val USER_NAME_KEY = "Username"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        toolbar = findViewById(R.id.dashboard_toolbar_id)
        setSupportActionBar(toolbar)

        toolbar.setOnClickListener{
            SaveSharedPreference.deleteAllPreferences(this)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        username = findViewById(R.id.username_dashboard_id)
        username.text = intent.getStringExtra(USER_NAME_KEY).toString()


        courseCategoryRecycler = findViewById(R.id.courses_category_recycler_id)
        val indLocale = Locale("en","IN")
        val ind = NumberFormat.getCurrencyInstance(indLocale)
        courseCategoryList = arrayListOf()

        // Beginner Courses
        val beginnerCourseList = arrayListOf<Course>()
        description = "C++ Fundamentals, the first step in your journey to become an expert programmer, " +
                "is a uniquely designed course for beginners where you can start learning C++ from scratch. " +
                "If you have no prior experience in coding and face difficulty in submitting problems on online judges, " +
                "then this C++ course is the first step for you. " +
                "You can hone problem-solving skills by getting hands-on experience and solving 50+ coding questions on topics like arrays, pointers, strings, 2D arrays. " +
                "Through the in-depth video lectures, this course teaches you the art of solving problems on online judges. " +
                "The course is taught by our most popular instructor, " +
                "Amit Sharma who is known for his teaching & Rohan kumar who is known for his competitive programming skills."
        beginnerCourseList.add(Course(R.drawable.cpp_fundamentals,"C++ Fundamentals",ind.format(999), arrayListOf<String>("Amit Sharma","Rohan Kumar"),description))
        beginnerCourseList.add(Course(R.drawable.cpp_standard_template_library,"C++ Standard Template Library",ind.format(1999),arrayListOf<String>("Sumit Kumar"),description))
        beginnerCourseList.add(Course(R.drawable.java_fundamentals,"Java Fundamentals ",ind.format(1999),arrayListOf<String>("Amit Sharma"),description))
        beginnerCourseList.add(Course(R.drawable.python_fundamentals,"Python Fundamentals",ind.format(999),arrayListOf<String>("Rohit Sharma",),description))
        description = "First of its kind, " +
                "our Java online course for beginners is a uniquely designed online course in Data Structures" +
                " and Algorithms to aid your journey right from the beginning to the very end in becoming the most skilled software engineers across the globe." +
                " Our online course in Java is not only in absolute coherence with our most sought after classroom program, " +
                "but also provides you the comfort of learning at your home. With over 300 video lectures and several practice problems." +
                " Through these online classes, " +
                "the students will not only become more efficient with their solutions by optimizing space and time but this course will also provide them a firm base to excel " +
                "in all their programming interviews. " +
                "The core focus of these Java classes for beginners is to maintain an equilibrium between theory and practical, " +
                "thus providing the programmers with an ample amount of practice of questions based on Sorting, Searching, Greedy Algorithms, " +
                "Divide and Conquer Algorithms, Dynamic Programming along with a comprehensive revision of data structures like linked-lists, Trees, Graphs, Heaps, Hashing etc. " +
                "The user can opt for the complete bundle, or just the advanced part of the course."
        beginnerCourseList.add(Course(R.drawable.java_master,"Java Master Course",ind.format(3999),arrayListOf<String>("Rohit Sharma","Rohan Kumar"),description))
        courseCategoryList.add(CourseCategory("Beginner Courses",beginnerCourseList))

        //Intermediate Course
        val intermediateList= arrayListOf<Course>()
        description = "Introducing our newest courses on Data Structures and Algorithms starting this 2 June - 15 July. " +
                "The course will all important data structures and algorithmic knowledge required for interviews."
        intermediateList.add(Course(R.drawable.datastructures_and_algorithms_in_cpp,"Data Structures and Algorithms in C++",ind.format(4999),arrayListOf<String>("Sushma Thapa","Aman Joshi"),description))
        description = "Begin your career in software development with the introduction to Data Structures and Algorithms in Java. Java, " +
                "an Object Oriented Programming is one of the most sought after programming language and is the foundation of the Android operating system. " +
                "Java is a perfect computer language for being competitive in today’s industry requirements.Designed for beginners, " +
                "our online java course is a hands on course where we focus on developing core programming concepts and equip you to code solutions for complex problems using Java.\n"
        intermediateList.add(Course(R.drawable.datastructures_and_algorithm_java,"Data Structures and Algorithms in Java",ind.format(3999), arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        intermediateList.add(Course(R.drawable.datastructures_and_algorithms_with_in_python,"Data Structures and Algorithms in Python",ind.format(4999), arrayListOf<String>("Suman Thapa","Karan Negi"),description))
        intermediateList.add(Course(R.drawable.datastructure_in_c,"Data Structures in C",ind.format(3999), arrayListOf<String>("Kiran Bedi","Shubahm Jaiswal"),description))
        intermediateList.add(Course(R.drawable.algorithm_in_c,"Algorithms in C",ind.format(2999), arrayListOf<String>("Ankur Negi","Shashank Bhandari"),description))
        intermediateList.add(Course(R.drawable.java_collections,"Collections in Java",ind.format(1999), arrayListOf<String>("Arnab Goswami","Pulkit Sharma"),description))
        courseCategoryList.add(CourseCategory("Intermediate Courses",intermediateList))

        // Development Courses
        val developmentCourseList = arrayListOf<Course>()
        description = "Our Android Development online course facilitates and boosts your journey right from the fundamentals of UI to building a full-fledged Android app." +
                "This online course by Coding Blocks with over 100 recorded videos and 5 live webinars, covers the concepts such as UI design, firebase & push notifications, " +
                "hardware sensors, networking, and databases. With 24x7 doubt clearing support and regular assignments & evaluations, " +
                "the students through this online android development course within no time learn to integrate the most commonly used third-party libraries such as Google Maps, " +
                "REST APIs etc. to make powerful and interactive applications. Although good command over concepts such as OOPs, stacks, queues, and lists would come handy," +
                " even if the students do not possess prior knowledge about them, we shall help them cover every topic in detail before getting into Android. " +
                "These online Android Development classes will be covered in both - Java and Kotlin, together with the recently launched Android Jetpack framework."
        developmentCourseList.add(Course(R.drawable.android_app_development_master_course,"Android App Development Master Course",ind.format(12999),arrayListOf<String>("Rohit Sharma","Anshul Sinha"),description))
        developmentCourseList.add(Course(R.drawable.web_development_frontend,"Web Development Frontend",ind.format(8999),arrayListOf<String>("Garima Thapa","Yogesh Upadhyay"),description))
        developmentCourseList.add(Course(R.drawable.web_development_backend,"Web Development Backend ",ind.format(7999),arrayListOf<String>("Shubham Kumar"),description))
        developmentCourseList.add(Course(R.drawable.web_development_using_python_django,"Web Development Using Python DJango",ind.format(8999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        description = "The online course for Web Development by Coding Blocks is deftly designed with an aim to familiarize the young coders with all the know-how of developing " +
                "the most coherent and professional websites & web-portals." +
                " This online Web Development course is a project-based Full Stack web development course with backend in Node.JS. " +
                "As a part of these online Web Development classes, " +
                "the students will start off with the fundamentals of building basic websites and will go on to create more functional and complex portals. " +
                "The course will start with topics such as HTML, CSS, and JS and then move on to important concepts such as version control, databases, " +
                "Node.Js and advanced topics such as security. " +
                "Throughout the course, the students will be mentored in a manner that they develop proficiency with javascript for both Front-end as well as back-end use-cases. " +
                "By the end of this online Web Development training," +
                " the students should be equipped with all the essentials to bring into play their full-fledged live web projects such as e-commerce website. " +
                "Anyone with a good command of data structures like Stacks, Queues, and Lists, basics of algorithms like sorting, searching, " +
                "string manipulations and OOP(s) is good to go!"
        developmentCourseList.add(Course(R.drawable.web_development_with_nodejs,"Web Development with NodeJS",ind.format(9999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        courseCategoryList.add(CourseCategory("Development Courses",developmentCourseList))

        //Advance Courses
        val advanceCourseList = arrayListOf<Course>()
        description = "Data Science is one of the hottest fields of the 21st century. It is in high demand across the globe with bigwigs like Amazon, " +
                "Google, Microsoft paying handsome salaries and perks to data scientists. " +
                "This course provides you with a great kick-start in your data science journey by starting with Python Basics, Data Visualization, Data Scraping, " +
                "Building Web Scrappers using Scrapy, Data Cleaning and applying various machine learning algorithms like Linear Regression, Logistic Regression, " +
                "Decision Trees, Naive Bayes, Principal Component Analysis, Feature Engineering, T-SNE Visualizations, Deep Learning & Reinforcement Learning for video games." +
                " The complete course is very practical and makes sure you do sufficient hands-on practice on the concepts taught by solving assignments and challenges."
        advanceCourseList.add(Course(R.drawable.datascience_master_course,"Data Science Master Course",ind.format(9999),arrayListOf<String>("Mohit Kumar","Rohit Sharma"),description))
        advanceCourseList.add(Course(R.drawable.machine_learning_master_course,"Machine Learning Master Course",ind.format(19999),arrayListOf<String>("Mohit Kumar","Anuradha Sharma"),description))
        advanceCourseList.add(Course(R.drawable.dynamic_programming,"Dynamic Programming",ind.format(5999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        advanceCourseList.add(Course(R.drawable.interview_preparation_with_cpp,"Interview Preparation with C++",ind.format(13999),arrayListOf<String>("Shahank Kumar","Aman Dhatterwal"),description))
        advanceCourseList.add(Course(R.drawable.interview_preparation_with_java,"Interview Preparation with Java",ind.format(15999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        description = "The online Competitive Programming course by Coding Blocks is an ultimate online competitive coding training. " +
                "With an aim to leverage and optimize the problem-solving skills of the young programmers, " +
                "the course structure of this 8 weeks long online course is most extensively crafted to ensure their swift sail through the online coding challenges and code-athons." +
                " These online coding classes will cover concepts of Advanced Data Structures such as Segment Trees, Binary Index / Fenwick Trees. " +
                "The students will be taught to construct algorithms involving Dynamic Programming, Bitmasking, Greedy Algorithms, " +
                "and Divide & Conquer along with the essentials of advanced competitive programming topics." +
                " A good knowledge of basics (like sorting, searching, recursion ), " +
                "data-structures and space-time complexity analysis on problems will definitely ensure nifty learning. With more than 100 recorded videos and 5 live webinars, " +
                "along with 24x7 doubt clearing support to your aid, anyone on a binge to master the competitive coding tricks and techniques has absolutely no looking back!"
        advanceCourseList.add(Course(R.drawable.competitive_programming,"Competitive Programming",ind.format(16999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        courseCategoryList.add(CourseCategory("Advance Courses",advanceCourseList))

        //Python Course
        val pythonList = arrayListOf<Course>()
        pythonList.add(Course(R.drawable.machine_learning_with_python,"Machine Learning with Python",ind.format(3999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        pythonList.add(Course(R.drawable.python_beginner,"Python Programming Beginner Course",ind.format(2999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        description = "This is the most fundamental course in Python designed for beginners. " +
                "Python has now become one of the hottest and most sought-after programming languages and it can kickstart your Python programming skills from zero to hero." +
                " The course is going to encompass concepts like writing simple programs in Python, " +
                "built-in Data Structures and learning program execution techniques like Multithreading & Multiprocessing. " +
                "Python is extensively used in domains such as Big Data, Data Visualization, Machine Learning, Deep Learning, Artificial Intelligence, etc. " +
                "Our Python experts, Jatin Katyal and Himank, are the guiding instructors for the Python course. " +
                "Python is used extensively in the software development industry as well in Data Science. Popular Web Apps like Youtube & Instagram are built in Python. " +
                "To acquire advanced skills in Python, we advise the keen learners to further opt for the next and advanced level- Python for Data Science or Python for Developers."
        pythonList.add(Course(R.drawable.fundamentals_of_python,"Fundamentals of Python Programming Language",ind.format(2999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        description = "Python for Data Science is designed for users looking forward to build a career in Data Science and Machine Learning related domains. " +
                "You will learn how to do Data Visualization, Data Web Scraping using Scrapy & Beautiful Soup, " +
                "Exploratory Data Analysis, Basics of Image Processing using OpenCV. " +
                "The course focuses on hands-on experience in building Web Crawlers, File-handling using Pandas and Automation using Selenium. " +
                "You will learn Data Crunching using Web APIs like Twitter API,Google Maps API, etc. You will be working in 5 mini projects in the course." +
                "Having a prior knowledge of Python Basics is going to come in handy for this course as well." +
                " Prateek Narang, who is quite popular for his teaching methodology is the lead instructor for this course. " +
                "This exhaustively built course will get you placed at bigwigs like Curefit, Zeta, Goldman Sachs, Mercedes, Fractal Analytics, Amazon, 1mg, Analytics Vidhya, etc." +
                " Take the next leap by doing Machine Learning & Deep Learning after this course will help you to achieve your aim of becoming an industry ready data scientist."
        pythonList.add(Course(R.drawable.datascience_with_python,"Data Science with Python",ind.format(5999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        pythonList.add(Course(R.drawable.ai_python,"Artificial Intelligence Driven By Python",ind.format(6999),arrayListOf<String>("Garima Thapa","Rohit Sharma"),description))
        courseCategoryList.add(CourseCategory("Python Courses",pythonList))

        val adapter = CourseCategoryAdapter(this,courseCategoryList)
        courseCategoryRecycler.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        courseCategoryRecycler.adapter = adapter
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId)
//        {
//            android.R.id.home -> {finish()
//            return true}
//            else -> {false}
//        }
//    }
}