package com.example.tictactoe

data class GameState(
    val playerXCount: Int = 0,
    val playerOCount: Int = 0,
    val drawCount: Int = 0,
    val hintText: String = "Player 'x' turn",
    val currentTurn: BoardValues = BoardValues.CIRCLE,
    val hasWon: Boolean = false,
    val victoryType: VictoryType = VictoryType.NONE
)

enum class BoardValues {
    NONE, CIRCLE, CROSS
}

enum class VictoryType {
    NONE,
    HORIZONTAL1,
    HORIZONTAL2,
    HORIZONTAL3,
    VERTICAL1,
    VERTICAL2,
    VERTICAL3,
    DIAGONAL1,
    DIAGONAL2
}
