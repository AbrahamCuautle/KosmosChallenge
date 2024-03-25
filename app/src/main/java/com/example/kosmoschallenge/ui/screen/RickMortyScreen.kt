package com.example.kosmoschallenge.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.kosmoschallenge.R
import com.example.kosmoschallenge.model.RickMortyCharacter

@Composable
fun RickMortyScreen(
    viewModel: RickMortyViewModel = hiltViewModel()
) {
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    RickMortyContent(
        modifier = Modifier.fillMaxSize(),
        screenState = screenState
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RickMortyContent(
    modifier: Modifier = Modifier,
    screenState: RickMortyScreenState
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.title_screen))
                }
            )
        }
    ) { padding ->
        when(screenState) {
            is RickMortyScreenState.Failure -> {
                Box(modifier = Modifier
                    .padding(padding)
                    .fillMaxSize())  {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = stringResource(id = R.string.error_template, screenState.msg),
                        color = Color.Red
                    )
                }
            }
            RickMortyScreenState.Loading -> {
                Box(modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            is RickMortyScreenState.Success -> {
                ListAllCharacters(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize(),
                    characters = screenState.characters
                )
            }
        }
    }
}

@Composable
private fun ListAllCharacters(
    modifier: Modifier = Modifier,
    characters: List<RickMortyCharacter>
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(characters, key = { it.id }) { character ->
            RickMortyCharacter(
                modifier = Modifier.fillMaxWidth(),
                character = character
            )
        }
    }
}

@Composable
private fun RickMortyCharacter(
    modifier: Modifier = Modifier,
    character: RickMortyCharacter
) {
    var showDetails by rememberSaveable { mutableStateOf(false) }
    Card(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CharacterMainInfoRow(
                name = character.name,
                imageUrl = character.image,
                onBtnDetailsClick = { showDetails = !showDetails },
                textBtnDetails = if (showDetails) stringResource(id = R.string.btn_hide_details) else  stringResource(id = R.string.btn_show_details)
            )
        }
        AnimatedVisibility(visible = showDetails) {
            Column(
                modifier = Modifier.padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = stringResource(id = R.string.label_character_status, character.status))
                Text(text = stringResource(id = R.string.label_character_species,character.species))
                Text(text = stringResource(id = R.string.label_character_type, character.type))
                Text(text = stringResource(id = R.string.label_character_gender, character.gender))
                Text(text = stringResource(id = R.string.label_character_origin, character.origin.name))
                Text(text = stringResource(id = R.string.label_character_location, character.location.name))
            }
        }
    }
}
@Composable
private fun CharacterMainInfoRow(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String,
    textBtnDetails: String,
    onBtnDetailsClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop,
            model = imageUrl,
            contentDescription = name,
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = name)
            Button(onClick = onBtnDetailsClick) {
                Text(text = textBtnDetails)
            }
        }

    }
}

