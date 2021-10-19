package com.example.jetpack

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.model.Message
import com.example.jetpack.ui.theme.LearnJetpackTheme

internal class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackTheme {
                MessageCard(Message("xtine", "I'm learning!"))
            }
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.piehole),
                contentDescription = "Author profile picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "${message.author} said:",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.width(4.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

    @Preview(name = "Light Mode")
    @Preview(
        name = "Dark Mode",
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true
    )
    @Composable
    fun PreviewMessageCard() {
        LearnJetpackTheme {
            MessageCard(Message("Xtine", "I love my bunny."))
        }
    }
}