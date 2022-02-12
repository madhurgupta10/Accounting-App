package com.example.account.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.account.model.Invoice
import com.example.account.repository.InvoiceRepository
import com.example.account.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InvoiceDetailViewModel @Inject constructor(
    private val repository: InvoiceRepository,
    application: Application,
) : AndroidViewModel(application) {

    fun getInvoiceById(id: String?): LiveData<Invoice> = repository.getInvoiceById(id)

    fun deleteInvoice(invoice: Invoice) {
        viewModelScope.launch(Dispatchers.IO + NonCancellable) {
            repository.deleteInvoice(invoice)
        }
    }

    fun markInvoiceAsPaid(invoice: Invoice) {
        viewModelScope.launch(Dispatchers.IO + NonCancellable) {
            invoice.status = Constants.paid
            repository.markInvoiceAsPaid(invoice)
        }
    }

}