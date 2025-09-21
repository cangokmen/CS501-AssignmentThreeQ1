package com.example.assignmentthreeq1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignmentthreeq1.ui.theme.AssignmentThreeQ1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentThreeQ1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeightedSplitLayout()
                }
            }
        }
    }
}

@Composable
fun WeightedSplitLayout() {
    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight()
                .background(Color.Red)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "0.25 width")
        }

        Column(
            modifier = Modifier
                .weight(0.75f)
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .background(Color.Green)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "0.75 width - 2/10")
            }

            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth()
                    .background(Color.Cyan)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "0.75 width - 3/10")
            }

            Column(
                modifier = Modifier
                    .weight(5f)
                    .fillMaxWidth()
                    .background(Color.Yellow)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "0.75 width - 5/10")
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AssignmentThreeQ1Theme {
        WeightedSplitLayout()
    }
}
