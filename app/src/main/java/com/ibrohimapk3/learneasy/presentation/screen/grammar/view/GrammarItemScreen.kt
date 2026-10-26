package com.ibrohimapk3.learneasy.presentation.screen.grammar.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.core.component.TopBar
import com.ibrohimapk3.learneasy.presentation.screen.grammar.view.component.FormulaCard
import com.ibrohimapk3.learneasy.presentation.screen.grammar.view.component.exampleCardColors
import com.ibrohimapk3.learneasy.presentation.screen.grammar.view.component.splitText
import com.ibrohimapk3.learneasy.presentation.screen.grammar.viewModel.GrammarItemViewModel
import com.ibrohimapk3.learneasy.presentation.ui.theme.TextH4
import org.koin.androidx.compose.koinViewModel

@Composable
fun GrammarItemScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    id: Int,
    viewModel: GrammarItemViewModel = koinViewModel()
) {
    LaunchedEffect(id) {
        viewModel.loadItem(id)
    }

    val item by viewModel.item.collectAsState()
    val formulaList = splitText(item?.formula)
    val examplesList = item?.examples

    Column(modifier = modifier.fillMaxSize()) {
        TopBar(onClick = onBack, text = "Грамматика")

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 15.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = item?.title ?: "error",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = item?.explanation.orEmpty(),
                color = TextH4,
                fontSize = 18.sp,
            )
            Spacer(Modifier.height(10.dp))
            if (formulaList != null) {
                FormulaCard(formulaList)
            }
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Примеры:",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            examplesList?.forEachIndexed { index, text ->
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = exampleCardColors[index])
                ) {
                    Text(text = text , modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}

