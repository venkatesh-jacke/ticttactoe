package com.example.tictactoe

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameScreen(viewModel: GameViewModel) {

    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Player 'X' : ${state.playerXCount} ", fontSize = 16.sp)
            Text(text = "Draw : ${state.drawCount} ", fontSize = 16.sp)
            Text(text = "Player 'O' : ${state.playerOCount}", fontSize = 16.sp)

        }
        Text(
            text = "Tic Tac Toe",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color.Red
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(20.dp)),

            contentAlignment = Alignment.Center
        ) {
            Board()
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f)
            ) {
                viewModel.boardItems.forEach { (cellNo, boardCellValue) ->
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) { viewModel.onAction(UserAction.BoardTapped(cellNo)) },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AnimatedVisibility(
                                visible = viewModel.boardItems[cellNo] != BoardValues.NONE,
                                enter = scaleIn(
                                    tween(1000)
                                )
                            ) {
                                if (boardCellValue == BoardValues.CROSS) {
                                    Cross()
                                } else if (boardCellValue == BoardValues.CIRCLE) {
                                    Circle()
                                }
                            }

                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(visible = state.hasWon, enter = fadeIn(tween(2000))) {
                    DrawVictoryLine(state)
                }
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = state.hintText, fontSize = 24.sp)
            Button(
                onClick = { viewModel.onAction(UserAction.PlayAgainButtonClicked) },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp)
            ) {
                Text(text = "Play Again", fontSize = 16.sp)
            }


        }
    }
}


@Composable
fun DrawVictoryLine(state: GameState) {
    when (state.victoryType) {
        VictoryType.HORIZONTAL1 -> {
            H1()
        }

        VictoryType.HORIZONTAL2 -> {
            H2()
        }

        VictoryType.HORIZONTAL3 -> {
            H3()
        }

        VictoryType.VERTICAL1 -> {
            V1()
        }

        VictoryType.VERTICAL2 -> {
            V2()
        }

        VictoryType.VERTICAL3 -> {
            V3()
        }

        VictoryType.DIAGONAL1 -> {
            D1()
        }

        VictoryType.DIAGONAL2 -> {
            D2()
        }

        else -> {

        }


    }
}

@Composable
@Preview
fun PreviewGameScreen() {
    GameScreen(GameViewModel())
}
