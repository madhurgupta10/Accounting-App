package com.example.account.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Address(
    @SerializedName("street") val street: String,
    @SerializedName("city") val city: String,
    @SerializedName("postCode") val postCode: String,
    @SerializedName("country") val country: String,
) : Serializable