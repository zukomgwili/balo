package za.co.appelement.balo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.co.appelement.balo.ui.theme.BaloTheme

@Composable
fun InformationPanel(
    onClick: () -> Unit,
    modifier: Modifier,
    factor: State<Int>,
    score: State<Int>,
    counter: State<Int>
) {
    Row {
        Column {
            Button(
                onClick = onClick,
                modifier = modifier
                    .width(64.dp)
                    .height(64.dp)
            ) {
                Text(
                    text = factor.value.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
            Text(
                text = "factor",
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
        Spacer(modifier = Modifier.weight(1.0f))
        Column {
            Box(
                modifier = modifier
                    .width(64.dp)
                    .height(64.dp)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = score.value.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Text(
                text = "score",
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
        Spacer(modifier = Modifier.weight(1.0f))
        Column {
            Box(
                modifier = modifier
                    .width(64.dp)
                    .height(64.dp)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.tertiaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = counter.value.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
            Text(
                text = "seconds",
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun InformationPanelPreview(){
    val factor = remember {
        mutableIntStateOf(3)
    }
    val score = remember {
        mutableIntStateOf(7)
    }
    val counter = remember {
        mutableIntStateOf(5)
    }
    BaloTheme {
        InformationPanel(onClick = { }, modifier = Modifier, factor = factor, score = score, counter = counter)
    }
}