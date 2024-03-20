package com.runitrut.ruts_viewmodel_composed_exp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.runitrut.ruts_viewmodel_composed_exp.ui.theme.RutsviewmodelcomposedexpTheme

class MainActivity : ComponentActivity() {

    // added
    //private val viewModel by viewModels<ContactsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RutsviewmodelcomposedexpTheme {
                val viewModel = viewModel<ContactsViewModel>(
                    factory = object : ViewModelProvider.Factory{
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return ContactsViewModel(
                                helloWorld = "hello world"
                            ) as T
                        }
                    }
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    // added
                    color = viewModel.backgroundColor
                ) {
                    // added
                    Button(onClick = {
                        viewModel.changeBackgroundColor()
                    }) {
                        Text(text = "Change Color")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RutsviewmodelcomposedexpTheme {
        Greeting("Android")
    }
}