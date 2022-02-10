package com.example.account.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.account.model.Invoice
import com.example.account.repository.InvoiceRepository
import com.example.account.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InvoiceDetailViewModel @Inject constructor(
    private val repository: InvoiceRepository,
    application: Application,
) : AndroidViewModel(application) {

    fun deleteInvoice(invoice: Invoice) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteInvoice(invoice)
        }
    }

    fun editInvoice(invoice: Invoice) {

    }

    fun markInvoiceAsPaid(invoice: Invoice) {
        viewModelScope.launch(Dispatchers.IO) {
            invoice.status = Constants.paid
            repository.markInvoiceAsPaid(invoice)
        }
    }

}