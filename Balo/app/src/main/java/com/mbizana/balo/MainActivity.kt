package com.mbizana.balo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mbizana.balo.ui.theme.BaloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaloTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(modifier = modifier, onClick = { navController.navigate("game") })  }
        composable("game") {
            Game(
                modifier = modifier,
                onClick = { navController.navigate("home") } ,
                onGameOver = { navController.navigate("game-over") },
            )
        }
        composable("game-over") {
            GameOver(
                modifier = modifier,
                onClick = { navController.navigate("home") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BaloTheme {
        App()
    }
}

