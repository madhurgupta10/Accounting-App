package com.example.account.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.account.ui.shared.ActivityTemplate
import com.example.account.ui.main.components.ActivityContent
import com.example.account.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ActivityTemplate(
                content = {
                    ActivityContent(this, mainViewModel)
                }
            )
        }
    }
}