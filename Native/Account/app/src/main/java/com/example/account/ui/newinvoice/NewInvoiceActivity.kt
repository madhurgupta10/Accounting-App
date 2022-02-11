package com.example.account.ui.newinvoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
            val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
            ActivityTemplate(
                content = {
                    ActivityContent {
                        bottomBarState.value = it
                    }
                },
                showGoBack = true,
                activity = this,
                bottomBar = {
                    if (bottomBarState.value) {
                        BottomBar(this)
                    }
                }
            )
        }
    }
}