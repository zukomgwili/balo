package com.mbizana.balo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbizana.balo.ui.theme.BaloTheme

@Composable
fun MultipleDisplay(modifier: Modifier, multiple: State<Int>) {
    Row(modifier = modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = modifier
                .fillMaxWidth(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(color = MaterialTheme.colorScheme.tertiary),
            contentAlignment = Alignment.Center
        ) {
            Text(text = multiple.value.toString(), fontSize = 144.sp, color = MaterialTheme.colorScheme.onTertiary)
        }
    }
}

@Preview
@Composable
fun MultipleDisplayPreview(){
    BaloTheme {
        MultipleDisplay(modifier = Modifier, multiple = remember {
            mutableIntStateOf(7)
        })
    }
}