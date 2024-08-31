package br.com.fiap_02_wef.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.com.fiap_02_wef.model.Pessoa
import br.com.fiap_02_wef.repositorio.PessoaRepositorio
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NovaPessoaScreen(modifier: Modifier = Modifier, navController: NavHostController?) {

    val context = LocalContext.current
    val pessoaRepositorio = PessoaRepositorio(context)

    val nome = remember {
        mutableStateOf("")
    }

    val peso = remember {
        mutableStateOf("")
    }

    val dataNasc = remember {
        mutableStateOf("")
    }

    val altura = remember {
        mutableStateOf("")
    }

    val isUsado = remember {
        mutableStateOf(false)
    }

    //Configuração DatePicker
    val showDatePicker = remember {
        mutableStateOf(false)
    }
    val datePickerState = rememberDatePickerState()
    val dataSelecionada = datePickerState.selectedDateMillis?.let {
        converterMillsParaData(it)
    } ?: " "

    if (showDatePicker.value){
        Popup(
            onDismissRequest = {showDatePicker.value = false}
        ) {
            Card(
                modifier = Modifier.padding(16.dp)
            ) {
                DatePicker(state = datePickerState, showModeToggle = false)
            }
        }
    }

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(Color(0xFF2196F3))
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Adicionar uma pessoa",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = {
                    navController?.navigate("ListaPessoas")
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                Column(modifier = Modifier.padding(32.dp)) {
                    OutlinedTextField(
                        value = nome.value,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { nome.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Seu nome")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Words
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = peso.value,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { peso.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Seu peso")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Words
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = dataSelecionada.toString(),
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { dataNasc.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Data de nascimento")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        trailingIcon = {
                            IconButton(onClick = {
                                showDatePicker.value = !showDatePicker.value
                            }) {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = ""
                                )
                            }

                        }
                    )
//                    if (showDatePicker.value){
//                        Popup(
//                            onDismissRequest = {showDatePicker.value = false}
//                        ) {
//                            Card(
//                                modifier = Modifier.padding(16.dp)
//                            ) {
//                                DatePicker(state = datePickerState, showModeToggle = false)
//                            }
//                        }
//                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = altura.value,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { altura.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Sua altura")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = {
                            val pessoa = Pessoa(
                                nome = nome.value,
                                peso = peso.value.toDouble(),
                                dataNasc = dataSelecionada,
                                altura = altura.value.toDouble()
                            )
                           val id = pessoaRepositorio.salvar(pessoa);
                            Toast.makeText(context, "A pessoa ${nome} foi adicionada", Toast.LENGTH_LONG).show()
                            navController?.navigate(route = "listaPessoas")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color(
                                    0xFF2196F3
                                )
                            )
                    ) {
                        Text(
                            text = "Adicionar uma pessoa",
                            fontSize = 16.sp
                        )
                    }
                }
            }
        },
        bottomBar = {

        },

        )

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun NovaPessoaScreenPreview() {
    NovaPessoaScreen(navController = null)
}

fun converterMillsParaData(mills: Long): String {
    val formatador = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    formatador.timeZone = TimeZone.getTimeZone("GMT")
    return formatador.format(Date(mills))
}