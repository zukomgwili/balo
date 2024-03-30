package za.co.appelement.balo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.co.appelement.balo.ui.theme.BaloTheme

@Composable
fun GameOver(modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        ElevatedButton(
            onClick = onClick,
            modifier
                .width(150.dp)
                .height(150.dp),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Gray
            )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "game", fontSize = 30.sp, color = MaterialTheme.colorScheme.onSecondary)
                Text(text = "over", fontSize = 30.sp, color = MaterialTheme.colorScheme.onSecondary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameOverPreview() {
    BaloTheme {
        GameOver(onClick = {}, modifier = Modifier)
    }
}