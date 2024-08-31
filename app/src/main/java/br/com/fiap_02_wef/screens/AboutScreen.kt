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
import androidx.navigation.NavController
import br.com.fiap_02_wef.R

@Composable
fun AboutScreen(modifier: Modifier = Modifier, navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF021625)
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {navController.navigate(route = "login")}) {
                Text(text = stringResource(id = R.string.out))
            }
        }

    }
}
