package com.example.kosmoschallenge.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kosmoschallenge.data.repository.RickMortyRepository
import com.example.kosmoschallenge.mapper.RickMortyMapper
import com.example.kosmoschallenge.model.RickMortyCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface RickMortyScreenState {
    data object Loading: RickMortyScreenState
    data class Success(val characters: List<RickMortyCharacter>): RickMortyScreenState
    data class Failure(val msg: String): RickMortyScreenState
}

@HiltViewModel
class RickMortyViewModel @Inject constructor(
    private val repository: RickMortyRepository,
    private val mapper: RickMortyMapper
): ViewModel() {

    private val _screenState: MutableStateFlow<RickMortyScreenState> by lazy { MutableStateFlow(
        RickMortyScreenState.Loading
    ) }
    val screenState: StateFlow<RickMortyScreenState> = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllCharacters()
        }
    }

    private suspend fun getAllCharacters() {
        try {
            val results = repository.getAllCharacters()
            val characters = mapper.mapAll(results)
            _screenState.update {
                RickMortyScreenState.Success(characters)
            }
        } catch (e: Exception) {
            _screenState.update { RickMortyScreenState.Failure(e.localizedMessage.orEmpty()) }
        }
    }

}