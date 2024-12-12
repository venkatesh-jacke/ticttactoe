package com.example.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    var state by mutableStateOf(GameState())

    val boardItems: MutableMap<Int, BoardValues> = mutableStateMapOf(
        1 to BoardValues.NONE,
        2 to BoardValues.NONE,
        3 to BoardValues.NONE,
        4 to BoardValues.NONE,
        5 to BoardValues.NONE,
        6 to BoardValues.NONE,
        7 to BoardValues.NONE,
        8 to BoardValues.NONE,
        9 to BoardValues.NONE,
    )

    fun onAction(action: UserAction) {
        when (action) {
            is UserAction.PlayAgainButtonClicked -> {
                gameReset()
            }

            is UserAction.BoardTapped -> {
                addValuesToBoard(action.cellNo)
            }

        }
    }

    fun addValuesToBoard(cellNo: Int) {
        if (boardItems[cellNo] != BoardValues.NONE) return
        if (state.currentTurn == BoardValues.CIRCLE) {
            boardItems[cellNo] = BoardValues.CIRCLE
            if (checkForVictory(BoardValues.CIRCLE)) {
                state = state.copy(
                    hintText = "Player 'O' Won",
                    playerOCount = state.playerOCount + 1,
                    currentTurn = BoardValues.NONE,
                    hasWon = true
                )
            }
            else if (isFull()) {
                state = state.copy(hintText = "Game Draw", drawCount = state.drawCount + 1)

            } else {
                state =
                    state.copy(hintText = "Player 'X' turn", currentTurn = BoardValues.CROSS)

            }
        } else if (state.currentTurn == BoardValues.CROSS) {
            boardItems[cellNo] = BoardValues.CROSS
            if (checkForVictory(BoardValues.CROSS)) {
                state = state.copy(
                    hintText = "Player 'X' Won",
                    playerXCount = state.playerXCount + 1,
                    currentTurn = BoardValues.NONE,
                    hasWon = true
                )
            }
            else  if (isFull()) {
                state = state.copy(hintText = "Game Draw", drawCount = state.drawCount + 1)

            } else {
                state = state.copy(hintText = "Player 'O' turn", currentTurn = BoardValues.CIRCLE)

            }
        }
    }

    fun isFull(): Boolean {
        if (boardItems.containsValue(BoardValues.NONE)) return false
        return true
    }

    fun gameReset() {
        boardItems.forEach { i, _ ->
            boardItems[i] = BoardValues.NONE
        }
        state = state.copy(
            currentTurn = BoardValues.CROSS,
            hintText = "Player 'X turn",
            hasWon = false,
            victoryType = VictoryType.NONE,

        )
    }

    fun checkForVictory(cellValue: BoardValues): Boolean {
        when {
            boardItems[1] == cellValue && boardItems[2] == cellValue && boardItems[3] == cellValue -> {
                state = state.copy(
                    victoryType = VictoryType.HORIZONTAL1
                )
                return true
            }

            boardItems[4] == cellValue && boardItems[5] == cellValue && boardItems[6] == cellValue -> {
                state = state.copy(
                    victoryType = VictoryType.HORIZONTAL2
                )
                return true
            }

            boardItems[7] == cellValue && boardItems[8] == cellValue && boardItems[9] == cellValue -> {
                state = state.copy(
                    victoryType = VictoryType.HORIZONTAL3
                )
                return true
            }

            boardItems[1] == cellValue && boardItems[4] == cellValue && boardItems[7] == cellValue -> {
                state = state.copy(
                    victoryType = VictoryType.VERTICAL1
                )
                return true
            }

            boardItems[2] == cellValue && boardItems[5] == cellValue && boardItems[8] == cellValue -> {
                state = state.copy(
                    victoryType = VictoryType.VERTICAL2
                )
                return true
            }

            boardItems[3] == cellValue && boardItems[6] == cellValue && boardItems[9] == cellValue -> {
                state = state.copy(
                    victoryType = VictoryType.VERTICAL3
                )
                return true
            }

            boardItems[1] == cellValue && boardItems[5] == cellValue && boardItems[9] == cellValue -> {
                state = state.copy(
                    victoryType = VictoryType.DIAGONAL1
                )
                return true
            }

            boardItems[3] == cellValue && boardItems[5] == cellValue && boardItems[7] == cellValue -> {
                state = state.copy(
                    victoryType = VictoryType.DIAGONAL2
                )
                return true
            }

            else -> return false
        }

    }


}
