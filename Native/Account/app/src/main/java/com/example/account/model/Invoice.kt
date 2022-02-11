package com.example.account.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.account.utils.Constants
import com.example.account.utils.getNewInvoiceId
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "invoices")
data class Invoice(
    @PrimaryKey @SerializedName("id") var id: String = getNewInvoiceId(),
    @SerializedName("createdAt") var invoiceDate: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("paymentTerms") var paymentTerms: Int = 1,
    @SerializedName("clientName") var clientName: String = "",
    @SerializedName("clientEmail") var clientEmail: String = "",
    @SerializedName("status") var status: String = Constants.draft,
    @SerializedName("senderAddress") var senderAddress: Address = Address(),
    @SerializedName("clientAddress") var clientAddress: Address = Address(),
    @SerializedName("items") var items: MutableList<InvoiceItem> = mutableListOf(),
) : Serializable