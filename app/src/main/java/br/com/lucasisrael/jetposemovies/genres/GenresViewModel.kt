package br.com.lucasisrael.jetposemovies.genres

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.models.ClientResult
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.data.response.GenresResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(private val repository: GenresRepository): ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    private val _genres = MutableStateFlow(GenresResponse(listOf()))

    fun getFromRepository() {
        viewModelScope.launch {
            try {
                when(val response = repository.getGenres()) {
                    is ClientResult.ClientSuccess -> {
                        _genres.value = response.data
                        Log.d("GenresViewModel Success", _genres.toString())
                    }
                    is ClientResult.ClientError -> {
                        Log.d("GenresViewModel Error", response.toString())
                    }
                }
            } catch (e: CancellationException) {
                e.printStackTrace()
            }
        }
    }
}
