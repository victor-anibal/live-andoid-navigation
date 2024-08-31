package br.com.fiap_02_wef.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap_02_wef.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {

    val emailState = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val errorEmail = remember {
        mutableStateOf(false)
    }
    val tamanhoMaximo = 8

    Surface(
        modifier = modifier.fillMaxSize(), color = Color(0xffae6de6)
    ) {
        Column(
            modifier = Modifier.padding(
                    vertical = 32.dp, horizontal = 48.dp
                ), verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = stringResource(id = R.string.subtitle), color = Color.White
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = { email ->
                        emailState.value = email
                    },
                    label = {
                        Text(text = "E-mail")
                    }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it
                    },
                    label = {
                        Text(text = "Senha")
                    },
                    modifier = Modifier.fillMaxWidth()
                )


                OutlinedTextField(value = password.value, onValueChange = {
                   if (it.length <= tamanhoMaximo) password.value = it
                }, label = {
                    Text(text = stringResource(id = R.string.password))
                }, modifier = Modifier.fillMaxWidth()
                )
            }
            Button(
                onClick = { navController.navigate  (route = "novaPessoa") }
        }
                Modifier.fillMaxWidth()
                Text(text = stringResource(id = R.string.enter))
        }

    }
