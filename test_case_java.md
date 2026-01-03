# Test Cases

## Menu Input Validation

| Input | Expected Output | Status |
|-------|-----------------|--------|
| A | "Please enter a number from 1-4." | ✅ Success |
| b | "Please enter a number from 1-4." | ✅ Success |
| -1 | "Please enter a number from 1-4." | ✅ Success |
| 5 | "Please enter a number from 1-4." | ✅ Success |
| % | "Please enter a number from 1-4." | ✅ Success |

## Menu Options

| Input | Expected Output | Status |
|-------|-----------------|--------|
| 1 | Starts the game and asks the user to enter their choice | ✅ Success |
| 2 | Prints how to play the game | ✅ Success |
| 3 | Prints the purpose of the game | ✅ Success |
| 4 | Prints goodbye and closes the program | ✅ Success |

## Main Game Input Validation

| Input | Expected Output | Status |
|-------|-----------------|--------|
| -1 | "Invalid input. You did not press enter or 's', try again." | ✅ Success |
| 3 | "Invalid input. You did not press enter or 's', try again." | ✅ Success |
| B | "Invalid input. You did not press enter or 's', try again." | ✅ Success |
| S | "Invalid input. You did not press enter or 's', try again." | ✅ Success |
| % | "Invalid input. You did not press enter or 's', try again." | ✅ Success |

## Skip Mechanics

| Situation | Input | Expected Output | Status |
|-----------|-------|-----------------|--------|
| User < 40 points | s | "You cannot skip, as you're out of skips or/and have less than 40 points." | ✅ Success |
| User ≥ 40 points | s (first skip) | "You skipped your turn! You have 1 left" | ✅ Success |
| User ≥ 40 points | s (second skip) | "You skipped your turn! You have 0 left" | ✅ Success |
| User ≥ 40 points, 0 skips | s (third skip) | "You cannot skip, as you're out of skips or/and have less than 40 points." | ✅ Success |
| Computer ≥ 40 points | enter | Player rolls and computer skips, "Computer Skipped!" | ✅ Success |
| Normal turn | (press enter) | Game continues, starts turn, adds and outputs rolls accurately | ✅ Success |

## Win/Lose Conditions

| Situation | Expected Output | Status |
|-----------|-----------------|--------|
| After 10 rounds: Player 48, Computer 52 | "Computer busted, You Win!" + statistics | ✅ Success |
| After 10 rounds: Player 52, Computer 48 | "You busted, Computer Wins!" + statistics | ✅ Success |
| After 9 rounds: Player 39, Computer 52 | "Computer busted, You Win!" + statistics | ✅ Success |
| After 8 rounds: Player 51, Computer 37 | "You busted, Computer Wins!" + statistics | ✅ Success |
| After 10 rounds: Player 50, Computer 50 | "It's a tie, you both win!" + statistics | ✅ Success |
| After 10 rounds: Player 54, Computer 52 | "It's a tie, you both lose!" + statistics | ✅ Success |
| After 9 rounds: Player 50, Computer 48 | "50 points, You Win!" + statistics | ✅ Success |
| After 10 rounds: Player 45, Computer 50 | "50 points, Computer Wins!" + statistics | ✅ Success |
| After 10 rounds: Player 49, Computer 30 | "Game over. You had more points, You Win!" + statistics | ✅ Success |
| After 10 rounds: Player 45, Computer 49 | "Game over. Computer has more points, Computer Wins!" + statistics | ✅ Success |
| After 10 rounds: Player 32, Computer 32 | "Game over. Same points, It's a tie!" + statistics | ✅ Success |

## Doubles Penalty

| Situation | Expected Output | Status |
|-----------|-----------------|--------|
| User rolled 5 and 5, Computer at 23 points | "The Computer loses 10 points! (13)" | ✅ Success |
| Computer rolled 3 and 3, Player at 11 points | "The Player loses 10 points! (1)" | ✅ Success |

## Statistics Verification

**Test Case:** After 6 turns, player wins (computer busted)

```
Statistics:

Turns played: 6

You ended with 35 points.
Computer ended with 55 points.

Your least points in a single turn were 5 in Round 2.
Your highest points in a single turn were 10 in Round 1.
Your average points per turn were 5.83.

The computer's least points in a single turn were 6 in Round 4.
The computer's highest points in a single turn were 11 in Round 6.
Computer's average points per turn were 9.17.

Note: the turn number for the least and highest points are based off of the first occurrence of those points.
```

**Verification:** After checking the average, minimum, and maximum with manual calculation and reviewing the rolls, all math and output were correct. ✅ Success
