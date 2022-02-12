package com.example.account.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Address(
    @SerializedName("street") var street: String = "",
    @SerializedName("city") var city: String = "",
    @SerializedName("postCode") var postCode: String = "",
    @SerializedName("country") var country: String = "",
) : Serializable