package com.example.account.model.converter

import androidx.room.TypeConverter
import com.example.account.model.Address
import com.google.gson.Gson

class AddressConverter {
    @TypeConverter
    fun addressToString(address: Address): String = Gson().toJson(address)

    @TypeConverter
    fun stringToAddress(string: String): Address = Gson().fromJson(string, Address::class.java)

}