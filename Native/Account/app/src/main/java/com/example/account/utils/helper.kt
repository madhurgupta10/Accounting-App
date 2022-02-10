package com.example.account.utils

import com.example.account.model.InvoiceItem
import com.example.account.model.enums.InvoiceStatus
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

fun getNewInvoiceId(): String {
    val alphabets: CharRange = ('A'..'Z')
    val numbers: CharRange = ('0'..'9')
    val prefix: String = List(2) { alphabets.random() }.joinToString("")
    val suffix: String = List(4) { numbers.random() }.joinToString("")
    return prefix + suffix
}

fun getStatus(status: String): InvoiceStatus {
    when (status) {
        "paid" -> return InvoiceStatus.Paid
        "pending" -> return InvoiceStatus.Pending
        "draft" -> return InvoiceStatus.Draft
    }
    return InvoiceStatus.Draft
}

fun getDueDate(invoiceDate: String, paymentTerms: Int): String {
    val originalFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val calendar: Calendar = Calendar.getInstance()
    calendar.time = originalFormat.parse(invoiceDate)
    calendar.add(Calendar.DATE, paymentTerms)
    val newFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return newFormat.format(calendar.time)
}

fun getTotal(items: List<InvoiceItem>): String {
    var total = 0.0
    for (item in items) {
        total += item.price * item.quantity
    }
    total = total.toBigDecimal().setScale(2, RoundingMode.HALF_DOWN).toDouble()
    return java.text.NumberFormat.getCurrencyInstance(Locale.UK).format(total).replace(
        "£",
        "£ "
    )
}