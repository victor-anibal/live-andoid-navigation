package br.com.fiap_02_wef.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.com.fiap_02_wef.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xff2196f3)
        ) {
        Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Button(onClick = { navController.navigate(route = "about") }) {
                Text(text = stringResource(id = R.string.about))
            }
            Button(onClick = {navController.navigate(route = "login")}) {
                Text(text = stringResource(id = R.string.out))
            }
        }
    
        }
    }

@Preview (showBackground = true, showSystemUi =
true)

@Composable
private fun viewsc() {

}