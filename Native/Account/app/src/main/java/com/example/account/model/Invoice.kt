package com.example.account.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.account.utils.getNewInvoiceId
import com.google.gson.annotations.SerializedName

@Entity(tableName = "invoices")
data class Invoice(
    @PrimaryKey @SerializedName("id") var id: String = getNewInvoiceId(),
    @SerializedName("createdAt") val invoiceDate: String,
    @SerializedName("description") val description: String,
    @SerializedName("paymentTerms") val paymentTerms: Int,
    @SerializedName("clientName") val clientName: String,
    @SerializedName("clientEmail") val clientEmail: String,
    @SerializedName("status") val status: String,
    @SerializedName("senderAddress") val senderAddress: Address,
    @SerializedName("clientAddress") val clientAddress: Address,
    @SerializedName("items") val items: List<InvoiceItem>,
)