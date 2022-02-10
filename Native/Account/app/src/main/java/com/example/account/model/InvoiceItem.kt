package com.example.account.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "items",
    foreignKeys = [ForeignKey(
        entity = Invoice::class,
        parentColumns = ["id"],
        childColumns = ["parentInvoiceId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class InvoiceItem(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @SerializedName("name") val name: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("price") val price: Float,
    @ColumnInfo(index = true) val parentInvoiceId: String
)