package com.coderboot.booknotes.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coderboot.booknotes.base.Routes.Companion.LOGIN
import com.coderboot.booknotes.base.Routes.Companion.SPLASH

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent { Application() }
    }
}

@Composable
fun Application()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SPLASH, builder = {
        composable(SPLASH, content = {  })
        composable(LOGIN, content = {  })
    })
}

class Routes {
    companion object {
        const val SPLASH = "signup"
        const val LOGIN = "home"
    }
}
