package com.example.atividade_texfildebuttonemjetpackcomposer

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atividade_texfildebuttonemjetpackcomposer.ui.theme.ATIVIDADETEXFILDEBUTTONEMJETPACKCOMPOSERTheme
import com.example.atividade_texfildebuttonemjetpackcomposer.ui.theme.debugButtonColors
import com.example.atividade_texfildebuttonemjetpackcomposer.ui.theme.errorButtonColors
import com.example.atividade_texfildebuttonemjetpackcomposer.ui.theme.infoButtonColors
import com.example.atividade_texfildebuttonemjetpackcomposer.ui.theme.warningButtonColors

const val TAG = "TestAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ATIVIDADETEXFILDEBUTTONEMJETPACKCOMPOSERTheme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("JetPack")
            ActionButton(
                text = "Debug",
                buttonColors = debugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação do Botão */
                Log.d(TAG, "App: Clicou em DEBUG!")
            }
            ActionButton(
                text = "Info",
                buttonColors = infoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação do Botão */
                Log.i(TAG, "App: Clicou em INFO!")
            }
            ActionButton(
                text = "Warning",
                buttonColors = warningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação do Botão */
                Log.w(TAG, "App: Clicou em WARNING!")
            }
            ActionButton(
                text = "Error",
                buttonColors = errorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try {
                    throw RuntimeException("Clicou em Error!")
                } catch(ex: Exception) {
                    /* Ação do Botão */
                    Log.e(TAG, "${ex.message}")
                }
            }
        }
    }
}

@Composable
fun ActionButton(
        text: String,
        buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
        modifier: Modifier = Modifier,
        block: () -> Unit
    ) {
        ElevatedButton(
            onClick = block,
            shape = RoundedCornerShape(5.dp),
            colors = buttonColors,
            modifier = modifier
        ) {
            Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Aula de $name!",
        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppView() {
    ATIVIDADETEXFILDEBUTTONEMJETPACKCOMPOSERTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview() {
    ActionButton(text = "Cadastrar") {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ATIVIDADETEXFILDEBUTTONEMJETPACKCOMPOSERTheme {
        Greeting("JetPack")
    }
}