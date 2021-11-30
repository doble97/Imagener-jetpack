package com.example.imagenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.imagenes.ui.theme.ImagenesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImagenesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ListaPokemon()
                }
            }
        }
    }
}

@Composable
fun ListaPokemon() {
    val  scrollstate = rememberLazyListState()

    LazyColumn (state = scrollstate){
/*        items(100) {
            Surface(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(text = "Elemento $it", modifier = Modifier.background(Color.DarkGray))
            }
        }*/
        items(100) {
            Elemento(index = it)
        }
    }
}

@Composable
fun Elemento(index: Int) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .border(1.dp, Color.Red)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"),
            contentDescription = "Pokemon Ditto",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImagenesTheme {
        ListaPokemon()
    }
}