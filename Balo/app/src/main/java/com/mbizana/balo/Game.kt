package com.mbizana.balo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mbizana.balo.ui.theme.BaloTheme

@Composable
fun Game(modifier: Modifier = Modifier, onClick: () -> Unit, onGameOver: () -> Unit) {
    val gameViewModel: GameViewModel = viewModel()
    val multiple = gameViewModel.multiple.collectAsState()
    val factor = gameViewModel.factor.collectAsState()
    val score = gameViewModel.score.collectAsState()
    val counter = gameViewModel.counter.collectAsState()
    val gameOver = gameViewModel.gameOver.collectAsState()
    if (gameOver.value){
        onGameOver()
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        InformationPanel(onClick, modifier, factor, score, counter)
        MultipleDisplay(modifier.weight(1.0f), multiple)
        ControlPanel(gameViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    BaloTheme {
        Game(onClick = {}, onGameOver = {})
    }
}