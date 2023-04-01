package com.myprojects.evc3

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: List<String>
)

