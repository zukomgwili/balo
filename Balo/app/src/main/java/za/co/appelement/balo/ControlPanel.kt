package za.co.appelement.balo

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import za.co.appelement.balo.ui.theme.BaloTheme

@Composable
fun ControlPanel(gameViewModel: GameViewModel) {
    Row(modifier = Modifier.padding(10.dp)) {
        ElevatedButton(
            onClick = { gameViewModel.validateNoAnswer() },
            modifier = Modifier
                .width(96.dp)
                .height(96.dp),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            )
        ) {
            Icon(
                Icons.Filled.Clear,
                contentDescription = "Not a multiple of the given factor",
                modifier = Modifier.size(48.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1.0f))
        ElevatedButton(
            onClick = { gameViewModel.validateYesAnswer() },
            modifier = Modifier
                .width(96.dp)
                .height(96.dp),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            )
        ) {
            Icon(
                Icons.Filled.Check,
                contentDescription = "Is a multiple of the given factor",
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ControlPanelPreview(){
    BaloTheme {
        ControlPanel(gameViewModel = viewModel())
    }
}