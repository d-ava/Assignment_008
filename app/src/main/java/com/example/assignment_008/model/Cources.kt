package com.example.assignment_008.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cources(
    @Json(name = "new_courses")
    val newCourses: List<NewCourse>,
    @Json(name = "active_courses")
    val activeCourses: List<ActiveCourse>
) {
    @JsonClass(generateAdapter = true)
    data class NewCourse(
        @Json(name = "id")
        val id: String,
        @Json(name = "icon_type")
        val iconType: String,
        @Json(name = "duration")
        val duration: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "question")
        val question: String,
        @Json(name = "main_color")
        val mainColor: String
    )

    @JsonClass(generateAdapter = true)
    data class ActiveCourse(
        @Json(name = "id")
        val id: String,
        @Json(name = "booking_time")
        val bookingTime: String,
        @Json(name = "progress")
        val progress: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "main_color")
        val mainColor: String,
        @Json(name = "background_color_percent")
        val backgroundColorPercent: String,
        @Json(name = "play_button_color_percent")
       val playButtonColorPercent: String,
        @Json(name = "image")
        val image: String
    )
}