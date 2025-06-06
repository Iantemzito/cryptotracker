package com.daecha.cryptodashboard.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daecha.cryptodashboard.cryptoViewModel.CryptoViewModel
import com.daecha.cryptodashboard.data.Coin


@Composable
fun HomeScreen(viewModel: CryptoViewModel = viewModel()){
    if (viewModel.isLoading){
        CircularProgressIndicator(modifier = Modifier.padding(20.dp))
    } else{
        LazyColumn (modifier = Modifier
            .fillMaxSize().padding(16.dp)){
            items(viewModel.coins) { coin ->
                CoinItem(coin)


            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp)) {
        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = {viewModel.searchQuery = it},
            label = { Text("Search")},
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        if (viewModel.isLoading){
            CircularProgressIndicator(modifier = Modifier.padding(20.dp))
        }else{
            LazyColumn {
                items(viewModel.filteredCoins){ coin ->
                    CoinItem(coin)

                }
            }
        }
    }

}

fun items(count: List<Coin>, itemContent: @Composable() (LazyItemScope.(index: Int) -> Unit)) {
    TODO("Not yet implemented")
}

@Composable
fun CoinItem(coin: Int) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(coin.toString()),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = "${coin.toInt()} (${coin.dp})")
            Text(text = "${coin.toInt()} USD", style = MaterialTheme.typography.bodySmall)
        }
    }
}

fun rememberAsyncImagePainter(image: String): Painter {
    TODO("Not yet implemented")
}


