package br.com.fiap_02_wef

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap_02_wef.screen.AboutScreen
import br.com.fiap_02_wef.screen.HomeScreen
import br.com.fiap_02_wef.screen.LoginScreen
import br.com.fiap_02_wef.ui.theme.WEF_v1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()

        setContent {
            WEF_v1Theme {

                val navController  = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ){
                    composable(route = "login"){ LoginScreen(navController = navController)}
                    composable(route = "home"){ HomeScreen(navController = navController)}
                    composable(route = "about"){ AboutScreen(navController = navController)}

                    
                }
            }
        }
    }
}

// função de composição fica grafado com eletra maiúscula na primeira letra.
/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
        
    )
}*/
