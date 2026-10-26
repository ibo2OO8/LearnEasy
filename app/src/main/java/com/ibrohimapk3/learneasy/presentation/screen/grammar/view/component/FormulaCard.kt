package com.ibrohimapk3.learneasy.presentation.screen.grammar.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.ui.theme.FormulaColor

@Composable
fun FormulaCard(list: List<String>) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = FormulaColor)
        ) {
            FlowRow(
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                list.forEachIndexed { index, item ->
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    if (index < list.lastIndex) {
                        Text(
                            text = "+",
                            fontSize = 18.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}
