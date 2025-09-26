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

// MainActivity is the app's entry point, responsible for setting up the initial UI.
class MainActivity : ComponentActivity() {
    // The onCreate method is called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent defines the UI using Jetpack Compose functions.
        setContent {
            // AssignmentThreeQ1Theme applies the app's custom theme.
            AssignmentThreeQ1Theme {
                // Surface is a main container that provides a background color from the theme.
                Surface(
                    modifier = Modifier.fillMaxSize(), // The Surface will take up the entire screen.
                    color = MaterialTheme.colorScheme.background
                ) {
                    // This composable contains the main layout logic for the screen.
                    WeightedSplitLayout()
                }
            }
        }
    }
}

/**
 * A composable function that demonstrates how to use the `weight` modifier
 * to create complex, proportional layouts. The screen is split into sections
 * where each section's size is relative to its siblings.
 */
@Composable
fun WeightedSplitLayout() {
    // The top-level Row will divide the screen horizontally into two main sections.
    Row(modifier = Modifier.fillMaxSize()) {
        // This is the first child of the Row (the left column).
        Column(
            modifier = Modifier
                // The 'weight' modifier gives this Column 25% of the available width in the Row.
                .weight(0.25f)
                .fillMaxHeight() // Ensures the column takes up the full height of the screen.
                .background(Color.Red) // Sets a background color to make the area visible.
                .padding(8.dp), // Adds padding inside the column.
            // Centers the content both horizontally and vertically within the column.
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "0.25 width")
        }

        // This is the second child of the Row (the right column).
        Column(
            modifier = Modifier
                // This Column gets the remaining 75% of the available width.
                .weight(0.75f)
                .fillMaxHeight()
        ) {
            // This inner Column is the first child of the right-side container.
            Column(
                modifier = Modifier
                    // The 'weight' here is relative to its siblings inside the parent Column.
                    // The total weight is 2 + 3 + 5 = 10. This Column gets 2/10 of the height.
                    .weight(2f)
                    .fillMaxWidth() // Fills the width of its parent (the 0.75f column).
                    .background(Color.Green)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "0.75 width - 2/10")
            }

            // This is the second child of the right-side container.
            Column(
                modifier = Modifier
                    // This Column gets 3/10 of the available height.
                    .weight(3f)
                    .fillMaxWidth()
                    .background(Color.Cyan)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "0.75 width - 3/10")
            }

            // This is the third and final child of the right-side container.
            Column(
                modifier = Modifier
                    // This Column gets the remaining 5/10 of the available height.
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


/**
 * A preview composable that allows for rendering `WeightedSplitLayout` in Android Studio's design view.
 * `showSystemUi = true` renders the layout within a device frame, including status and navigation bars.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AssignmentThreeQ1Theme {
        WeightedSplitLayout()
    }
}
