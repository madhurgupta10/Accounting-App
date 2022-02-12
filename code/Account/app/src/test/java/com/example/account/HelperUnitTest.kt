package com.example.account

import com.example.account.model.InvoiceItem
import com.example.account.model.enums.InvoiceStatus
import com.example.account.utils.*
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class HelperUnitTest {

    @Test
    fun test_getNewInvoiceId_Length() {
        val id = getNewInvoiceId()
        assertEquals(id.length, 6)
    }

    @Test
    fun test_getStatus_paid() {
        val status = getStatus("paid")
        assertEquals(status, InvoiceStatus.Paid)
    }

    @Test
    fun test_getStatus_pending() {
        val status = getStatus("pending")
        assertEquals(status, InvoiceStatus.Pending)
    }

    @Test
    fun test_getStatus_draft() {
        val status = getStatus("draft")
        assertEquals(status, InvoiceStatus.Draft)
    }

    @Test
    fun test_getInvoiceDate_valid() {
        val date = getInvoiceDate("2000-01-01")
        assertEquals(date, "01 Jan 2000")
    }

    @Test
    fun test_getInvoiceDate_invalid() {
        val date = getInvoiceDate("234234234234")
        assertEquals(date, "")
    }

    @Test
    fun test_getInvoiceDateForDbFormat_valid() {
        val date = getInvoiceDateForDbFormat("01 Jan 2000")
        assertEquals(date, "2000-01-01")
    }

    @Test
    fun test_getInvoiceDateForDbFormat_invalid() {
        val date = getInvoiceDateForDbFormat("234234234234")
        assertEquals(date, "")
    }

    @Test
    fun test_getDueDate_valid() {
        val date = getDueDate("2000-01-01", 2)
        assertEquals(date, "03 Jan 2000")
    }

    @Test
    fun test_getDueDate_invalid() {
        val date = getDueDate("234234234234", 2)
        assertEquals(date, "")
    }

    @Test
    fun test_getTotal() {
        val total =
            getTotal(
                listOf(
                    InvoiceItem(price = 1.0f, quantity = 2, parentInvoiceId = "#AA1234"),
                    InvoiceItem(price = 2.0f, quantity = 1, parentInvoiceId = "#AA1234")
                )
            )
        assertEquals(total, "${Currency.getInstance(Locale.UK).symbol} 4.00")
    }

    @Test
    fun test_getItemTotal() {
        val total =
            getItemTotal(
                InvoiceItem(price = 1.0f, quantity = 2, parentInvoiceId = "#AA1234"),
            )
        assertEquals(total, "${Currency.getInstance(Locale.UK).symbol} 2.00")
    }

    @Test
    fun test_getItemTotal_qty_price() {
        val total = getItemTotal(price = 1.0f, quantity = 2)
        assertEquals(total, "2.0")
    }

    @Test
    fun test_getPrice() {
        val total = getPrice(price = 1.0f)
        assertEquals(total, "${Currency.getInstance(Locale.UK).symbol} 1.00")
    }

}