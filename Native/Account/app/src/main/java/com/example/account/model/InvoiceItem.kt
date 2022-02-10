package com.example.account.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
    @SerializedName("name") var name: String,
    @SerializedName("quantity") var quantity: Int,
    @SerializedName("price") var price: Float,
    @ColumnInfo(index = true) var parentInvoiceId: String
) : Serializable