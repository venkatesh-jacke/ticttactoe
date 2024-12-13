# Tic-Tac-Toe App

A modern implementation of the classic Tic-Tac-Toe game built in **Android** using **Jetpack Compose**. This app demonstrates a clean architecture approach, leveraging **ViewModels**, **Canvas**, and **Sealed Classes** for an intuitive and interactive gaming experience.

<img src="https://github.com/venkatesh-jacke/ticttactoe/blob/master/Gamecreen.png?raw=true" width="200" height="400" />


![GameScreen](https://github.com/venkatesh-jacke/ticttactoe/blob/master/Gamecreen.png)

---

## Features

- **Interactive Gameplay**: Play the classic Tic-Tac-Toe game on an intuitive and visually appealing interface.
- **State Management with ViewModel**: The app uses Jetpack ViewModel to manage game state and lifecycle efficiently.
- **Custom UI with Canvas**: The board and game elements are drawn dynamically using Canvas for a unique and creative design.
- **Robust Architecture**: Implements sealed classes for game states, ensuring a clean and type-safe structure.
- **Responsive Design**: Optimized for different screen sizes using Jetpack Compose’s flexibility.

---

## Tech Stack

### Languages & Frameworks:
- **Kotlin**: For app development.
- **Jetpack Compose**: For building declarative UI components.

### Libraries & Tools:
- **Jetpack ViewModel**: To manage UI-related data in a lifecycle-conscious way.
- **Canvas API**: To create a custom-drawn Tic-Tac-Toe board.
- **Sealed Classes**: For defining game states (e.g., PlayerTurn, Win, Draw).

---

## Screenshots

### 1. Game Board
Dynamic and interactive game board created using Canvas.

### 2. Winning Screen
Highlights the winning line and declares the winner.

---

## Code Overview

### Game Logic
- The game logic is managed using a **ViewModel**, ensuring a clean separation of concerns.
- **Sealed Classes** are used to represent different game states:
  - `PlayerTurn`
  - `Win`
  - `Draw`

### UI Design
- The game board and elements are drawn using **Canvas**, providing a fully customizable and responsive UI.
- Composables are used for additional UI elements like player turn indicators and win/draw messages.

---

## Future Enhancements

- Add an **AI Opponent** for single-player mode.
- Implement animations for moves and winning sequences.
- Add support for themes (light and dark mode).

---

## Contributing

Contributions are welcome! Feel free to fork this repository and submit a pull request. For major changes, please open an issue to discuss what you would like to change.

---



## Contact

For questions or feedback, feel free to reach out:
- **Email**: [venkateshjacke@gmail.com](mailto:venkateshjacke@gmail.com)
- **LinkedIn**: [Venkatesh Ezhumalai](https://www.linkedin.com/in/venkatesh-e-700a41204/)

