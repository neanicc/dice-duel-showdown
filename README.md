# 🎲 Dice Duel Showdown: Fifty or Bust

A strategic turn-based dice game implemented in both **Java** and **Python**, showcasing object-oriented programming principles, game logic design, and clean code architecture.

---

## 📖 About

**Dice Duel Showdown** is a 1v1 dice game where you compete against a computer opponent. Roll two dice each turn and try to reach exactly **50 points** within **10 turns**—but be careful not to bust!

The game features strategic skip mechanics, penalty rules for doubles, and end-game statistics tracking, making every match unique and engaging.

---

## 🎮 How To Play

| Rule | Description |
|------|-------------|
| **Objective** | Get closest to 50 points without going over |
| **Turns** | 10 turns per game |
| **Win Condition** | Reach exactly 50, or have more points than opponent (under 50) |
| **Bust** | Go over 50 points = automatic loss |
| **Doubles Penalty** | Roll doubles → opponent loses 10 points |
| **Player Skips** | 2 skips available after reaching 40+ points |
| **Computer Skips** | 30% skip chance after 40+ points (unlimited) |

---

## 🛠️ Technical Implementation

### Java Version
The Java implementation demonstrates advanced **Object-Oriented Programming** concepts:

```
├── MainProgramFinal.java    # Entry point & game loop
├── MenuFinal.java           # Menu system with method overloading
├── GameFinal.java           # Core game logic & parent class
├── GameStatsFinal.java      # Statistics calculation with recursion
├── PlayerClass.java         # Player subclass (extends GameFinal)
└── ComputerClass.java       # Computer subclass (extends GameFinal)
```

### Python Version
The Python implementation showcases **modular programming** and clean function design:

```
└── full-dice-duel.py        # Complete game with modular functions
```

---

## 💡 Key Programming Concepts

### Java

| Concept | Implementation |
|---------|----------------|
| **Inheritance** | `PlayerClass` and `ComputerClass` extend `GameFinal` superclass |
| **Method Overloading** | `Details(int)` for game guide, `Details(double)` for purpose |
| **Encapsulation** | Private fields with public getters/setters (`GetPoints()`, `ModifyPoints()`) |
| **Recursion** | `ComputerMaxPoints()`, `PlayerMinPoints()` for statistics calculation |
| **Exception Handling** | Try-catch blocks for input validation |
| **Collections** | `ArrayList<int[]>` for storing roll history |

### Python

| Concept | Implementation |
|---------|----------------|
| **Modular Design** | Separate functions for menu, game logic, rolls, and statistics |
| **List Operations** | `append()`, `sum()`, `max()`, `sorted()`, `count()` |
| **Exception Handling** | Try-except for input validation |
| **Random Generation** | `random.randint()` for dice simulation |
| **Animation** | `time.sleep()` for rolling animation effect |

---

## 📊 Features

- **Real-time Statistics** — Track min/max/average points per turn
- **Rolling Animation** — Visual feedback with timed dot animation
- **Input Validation** — Robust error handling for invalid inputs
- **Balanced Gameplay** — Strategic skip mechanics for fair competition
- **ASCII Art** — Stylized title screen

---

## 🚀 Getting Started

### Java
```bash
# Compile all files
javac *.java

# Run the game
java MainProgramFinal
```

### Python
```bash
# Run directly
python full-dice-duel.py
```

---

## 🧠 Design Decisions

1. **Dual Implementation** — Built in both Java and Python to demonstrate language versatility and compare OOP vs procedural approaches

2. **Balanced Skip Mechanic** — Player gets limited skips while computer has probability-based unlimited skips, creating strategic depth without unfair advantage

3. **Recursive Statistics** — Java version uses recursion for min/max calculation, demonstrating algorithmic thinking beyond simple iteration

4. **Modular Architecture** — Separation of concerns allows easy maintenance, testing, and future feature additions

---

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

---

## 👤 Author

Developed as a Grade 12 Computer Science culminating project, demonstrating proficiency in:
- Object-Oriented Programming
- Game Development Logic
- Multi-language Implementation
- Clean Code Practices
