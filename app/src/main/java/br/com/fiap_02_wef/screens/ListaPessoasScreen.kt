

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap_02_wef.repositorio.PessoaRepositorio
import br.com.fiap_02_wef.model.Pessoa

@Composable
fun ListaPessoasScreen(modifier: Modifier = Modifier, navController: NavHostController?) {

    val context = LocalContext.current
    val pessoaRepositorio = PessoaRepositorio(context)
    val listaPessoas = remember {
        mutableStateOf(pessoaRepositorio.listarPessoas())
    }

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color(0xFF2196F3))
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Cadastro de pessoas",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        content = {
            Column(modifier = Modifier.padding(it)) {

                LazyColumn {
                    items(listaPessoas.value){ pessoa ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(
                                    top = 8.dp,
                                    start = 16.dp,
                                    end = 16.dp
                                ),
                            shape = CutCornerShape(topEnd = 16.dp, bottomStart = 8.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(8.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column {
                                        Text(
                                            text = pessoa.nome
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = pessoa.peso,
                                            fontSize = 16.sp
                                        )
                                    }
                                    Text(
                                        text = "${pessoa.altura}",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }

            }
        },
        bottomBar = {

        },
        floatingActionButton = {
            Button(
                modifier = Modifier
                    .size(60.dp),
                shape = CircleShape,
                onClick = {
                    navController?.navigate("NovoLivro")
                },
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor = Color(0xFF2196F3)
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    )
    
}

private fun LazyListScope.items(count: List<Pessoa>, itemContent: LazyItemScope.(index: Int) -> Unit) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ListaPessoasScreenPreview() {
    ListaPessoasScreen(navController = null)
}


