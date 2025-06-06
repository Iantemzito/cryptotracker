package com.daecha.cryptodashboard.cryptoViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daecha.cryptodashboard.data.ApiService
import com.daecha.cryptodashboard.data.Coin
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    var coins by mutableStateOf<List<Coin>>(emptyList())
    var searchQuery by mutableStateOf("")
    val filteredCoins: List<Coin>
        get() = coins.filter {
            it.name.contains(searchQuery, ignoreCase = true) ||
            it.symbol.contains(searchQuery, ignoreCase = true)
        }


    var isLoading by mutableStateOf(true)

    init {
        fetchCoins()
    }

    private fun fetchCoins() {
        viewModelScope.launch {
            try {
                coins = ApiService.api.getTopCoins()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }
}