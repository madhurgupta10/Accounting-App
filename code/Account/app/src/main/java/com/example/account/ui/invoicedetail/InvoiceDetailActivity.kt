package com.example.account.ui.invoicedetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.account.ui.invoicedetail.components.ActivityContent
import com.example.account.ui.invoicedetail.components.BottomBar
import com.example.account.ui.shared.ActivityTemplate
import com.example.account.viewmodel.InvoiceDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class InvoiceDetailActivity : ComponentActivity() {

    private val invoiceDetailViewModel: InvoiceDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val invoice = invoiceDetailViewModel.getInvoiceById(intent.getStringExtra("id"))
                .observeAsState(null)
            ActivityTemplate(
                content = {
                    invoice.value?.let {
                        ActivityContent(it)
                    }
                },
                bottomBar = {
                    invoice.value?.let {
                        BottomBar(it, invoiceDetailViewModel, this)
                    }
                },
                showGoBack = true,
                activity = this
            )
        }
    }
}