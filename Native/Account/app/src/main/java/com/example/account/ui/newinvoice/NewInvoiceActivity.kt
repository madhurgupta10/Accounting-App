package com.example.account.ui.newinvoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.account.ui.newinvoice.components.ActivityContent
import com.example.account.ui.newinvoice.components.BottomBar
import com.example.account.ui.shared.ActivityTemplate
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class NewInvoiceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ActivityTemplate(
                content = {
                    ActivityContent()
                },
                showGoBack = true,
                activity = this,
                bottomBar = {
                    BottomBar(this)
                }
            )
        }
    }
}