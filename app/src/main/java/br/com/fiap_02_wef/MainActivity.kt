package br.com.fiap_02_wef

import ListaPessoasScreen
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap_02_wef.screens.AboutScreen
import br.com.fiap_02_wef.screens.HomeScreen
import br.com.fiap_02_wef.screens.LoginScreen
import br.com.fiap_02_wef.ui.theme.WEF_v1Theme
import br.com.fiap_02_wef.screens.NovaPessoaScreen
class MainActivity() : ComponentActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()

        setContent {
            WEF_v1Theme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable(route = "login") { LoginScreen(navController = navController) }
                    composable(route = "home") { HomeScreen(navController = navController) }
                    composable(route = "about") { AboutScreen(navController = navController) }
                    composable(route = "listaPessoas") { ListaPessoasScreen(navController = navController) }
                    composable(route = "novaPessoa") { NovaPessoaScreen (navController = navController)

                }
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
