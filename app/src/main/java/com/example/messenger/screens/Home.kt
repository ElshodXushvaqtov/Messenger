package com.example.messenger.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.messenger.module.IconComponentDrawable
import com.example.messenger.module.IconComponentImageVector
import com.example.messenger.module.Person
import com.example.messenger.module.personList


@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            Header_Stories()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.White, RoundedCornerShape(
                            topStart = 30.dp, topEnd = 30.dp
                        )
                    )
            ) {
                LazyColumn(
                    modifier = Modifier.padding(bottom = 15.dp, top = 30.dp)
                ) {
                    items(personList, key = { it.id }) {
                        UserEachRow(person = it) {
                            navHostController.currentBackStackEntry?.savedStateHandle?.set(
                                "data",
                                it
                            )
                            navHostController.navigate("chats")
                        }
                    }
                }
            }
        }

    }

}

@Composable
fun Header_Stories() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp)
    ) {
        Header()
        StoryRecycler()
    }
}

@Composable
fun StoryRecycler() {
    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
        item {
            AddStory()
            Spacer(modifier = Modifier.width(10.dp))
        }
        items(personList, key = { it.id }) {
            UserStory(person = it)
        }
    }
}

@Composable
fun UserEachRow(
    person: Person,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .noRippleEffect { onClick() }

    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconComponentDrawable(icon = person.icon, size = 60.dp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        person.name?.let {
                            Text(
                                text = it, style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Okay",
                            style = TextStyle(
                                color = Color.Gray, fontSize = 14.sp
                            )
                        )
                    }

                }
                Text(
                    text = "12:00 PM", style = TextStyle(
                        color = Color.Gray, fontSize = 12.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color(0XFFEFF0F1))
        }
    }

}

@Composable
fun UserStory(
    person: Person, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(end = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .border(1.dp, Color.Red, CircleShape)
                .background(Color.Black, shape = CircleShape)
                .size(70.dp),
            contentAlignment = Alignment.Center,
        ) {
            IconComponentDrawable(icon = person.icon, size = 65.dp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        person.name?.let {
            Text(
                text = it, style = TextStyle(
                    color = Color.White, fontSize = 13.sp,
                ), modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

    }
}


@Composable
fun AddStory(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .border(2.dp, Color.DarkGray, shape = CircleShape)
                .background(Color.Yellow, shape = CircleShape)
                .size(70.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(Color.Black, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconComponentImageVector(
                    icon = Icons.Default.Add,
                    size = 12.dp,
                    tint = Color.Yellow
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Add Story", style = TextStyle(
                color = Color.White, fontSize = 13.sp,
            ), modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }

}

@Composable
fun Header() {

    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300
            )
        ) {
            append("Welcome Back, ")
        }
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        ) {
            append("Elshodbek")
        }
    }

    Text(text = annotatedString)

}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.noRippleEffect(onClick: () -> Unit) = composed {
    clickable(
        interactionSource = MutableInteractionSource(),
        indication = null
    ) {
        onClick()
    }
}


@Preview
@Composable
private fun TestUI() {

    HomeScreen(navHostController = rememberNavController())

}