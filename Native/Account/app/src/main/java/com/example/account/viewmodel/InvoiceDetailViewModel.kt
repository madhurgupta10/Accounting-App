package com.example.account.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.account.model.Invoice
import com.example.account.repository.InvoiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InvoiceDetailViewModel @Inject constructor(
    private val repository: InvoiceRepository,
    application: Application,
) : AndroidViewModel(application) {

    fun deleteInvoice(invoice: Invoice) {

    }

    fun editInvoice(invoice: Invoice) {

    }

    fun markInvoiceAsPaid(invoice: Invoice) {

    }

}