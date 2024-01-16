package kr.ac.kumoh.ce.prof01.jet07composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.prof01.jet07composable.ui.theme.Jet07ComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var count1 by rememberSaveable { mutableIntStateOf(0) }
    var count2 by rememberSaveable { mutableIntStateOf(0) }

    Jet07ComposableTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Counter(
                    Modifier.background(Color(0xFFFE7A36)),
                    count1) {
                    count1 = it
                }
                Counter(
                    Modifier.background(Color(0xFF280274)),
                    count2) {
                    count2 = it
                }
            }
        }
    }
}

@Composable
fun ColumnScope.Counter(
    modifier: Modifier = Modifier,
    count: Int,
    onChangeCount: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .weight(1F)
            .padding(8.dp)
            .background(Color(0xFFE9F6FF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = count.toString(),
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 100.sp,
            textAlign = TextAlign.Center,
        )

        Row {
            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1F),
                onClick = { onChangeCount(count + 1) }
            ) {
                Text("증가", fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1F),
                onClick = { if (count > 0) onChangeCount(count - 1) }
            ) {
                Text("감소", fontSize = 30.sp)
            }
        }
    }
}