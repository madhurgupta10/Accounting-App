package com.example.account.repository

import androidx.lifecycle.LiveData
import com.example.account.db.dao.InvoiceDao
import com.example.account.model.Invoice
import javax.inject.Inject

class InvoiceRepository @Inject constructor(
    private val invoiceDao: InvoiceDao
) {

    val invoices: LiveData<List<Invoice>> = invoiceDao.readAllInvoices()

    suspend fun addAllInvoices(invoices: List<Invoice>) {
        for (invoice in invoices) {
            invoiceDao.addInvoice(invoice)
        }
    }

    fun getInvoiceById(id: String?): LiveData<Invoice> {
        return invoiceDao.getInvoiceById(id)
    }

    suspend fun deleteInvoice(invoice: Invoice) {
        invoiceDao.deleteInvoice(invoice)
    }

    suspend fun markInvoiceAsPaid(invoice: Invoice) {
        invoiceDao.updateInvoice(invoice)
    }

}