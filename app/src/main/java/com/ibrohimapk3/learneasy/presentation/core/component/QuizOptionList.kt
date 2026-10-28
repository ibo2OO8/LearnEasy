package com.ibrohimapk3.learneasy.presentation.core.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.ui.theme.PrimaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.ThirdlyBlue

private val OptionTextColor = Color(0xFF0B1B3F)

@Composable
fun QuizOptionList(
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        options.forEach { option ->
            QuizOptionItem(
                text = option,
                selected = option == selectedOption,
                enabled = enabled,
                onClick = { onOptionSelected(option) }
            )
        }
    }
}

@Composable
private fun QuizOptionItem(
    text: String,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (selected) ThirdlyBlue else Color.White
    val borderColor = if (selected) PrimaryBlue else PrimaryBlue.copy(alpha = 0.3f)
    val borderWidth = if (selected) 2.dp else 1.5.dp

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 58.dp)
            .clickable(enabled = enabled, onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        color = backgroundColor,
        border = BorderStroke(borderWidth, borderColor)
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = OptionTextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

