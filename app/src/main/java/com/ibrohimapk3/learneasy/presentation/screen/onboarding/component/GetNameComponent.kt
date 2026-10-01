package com.ibrohimapk3.learneasy.presentation.screen.onboarding.component

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.R
import com.ibrohimapk3.learneasy.presentation.core.component.NavigationBtn

@Composable
fun GetNameComponent(modifier: Modifier, nextScreen: () -> Unit) {
    val context = LocalContext.current
    val name = remember { mutableStateOf("") }
    val checkName = remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(top = 30.dp, bottom = 28.dp)
                .size(125.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.get_name_icon),
            contentDescription = "",
        )
        Card(
            modifier = Modifier
                .height(224.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(4.dp),
        ) {
            Text(
                text = "Как вас зовут?",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 24.dp, bottom = 12.dp)
            )
            Text(
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Давайте познакомимся!",
                fontSize = 16.sp
            )
            Text(
                text = "Ваше имя",
                modifier = Modifier
                    .padding(start = 24.dp)
                    .align(Alignment.Start),
                fontWeight = FontWeight.W600
            )
            TextField(
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 24.dp, end = 24.dp, start = 24.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(12.dp),
                        color = if (isFocused) Color.Black else Color.Gray,

                        )
                    .onFocusChanged {
                        isFocused = it.isFocused
                    },
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,

                    ),
                placeholder = { Text(text = "Например, Саша") },
            )
        }
        Spacer(Modifier.weight(1F))
        NavigationBtn(text = "Далее", click = {
            if (name.value.isBlank()) {
                Toast.makeText(
                    context,
                    "Выберите уровень",
                    Toast.LENGTH_SHORT
                ).show()
            } else nextScreen()
        })
    }
}