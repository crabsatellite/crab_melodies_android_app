package com.crab.crabmelodies

// customized extend AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import coil.compose.AsyncImage
import com.crab.crabmelodies.ui.theme.SpotifyTheme
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)

        val navHostFragment =supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        navController.setGraph(R.navigation.nav_graph)

        NavigationUI.setupWithNavController(navView, navController)
        navView.setOnItemSelectedListener{
            NavigationUI.onNavDestinationSelected(it, navController)
            navController.popBackStack(it.itemId, inclusive = false)
            true
        }

    }
}


@Composable
private fun AlbumCover() {
    Column {
        Box(modifier = Modifier.size(160.dp)) {
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/en/d/d1/Stillfantasy.jpg",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = "Still Fantasy",
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 2.dp)
                    .align(Alignment.BottomStart),
            )
        }

        Text(
            text = "Jay Chou",
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            color = Color.LightGray,
        )
    }
}
@Preview(showBackground = true, widthDp = 412, heightDp = 732)
@Composable
fun DefaultPreview() {
    SpotifyTheme {
        Surface {
            AlbumCover() // <- this one
        }
    }
}
