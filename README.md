# Sudoku-Solver
This project implements a Sudoku solver in Java using a recursive backtracking algorithm. Given any valid 9×9 Sudoku board with empty cells represented by '.', the program fills in the missing values while respecting Sudoku constraints (rows, columns, and 3×3 sub-boxes).

The solution modifies the board in place and prints the completed Sudoku grid once a valid solution is found.

Approach: 
Uses backtracking to try valid digits (1–9) in empty cells.

Maintains a HashMap to track:
Digits already used in each row
Digits already used in each column
Digits already used in each 3×3 sub-box

Recursively fills the first available empty cell and backtracks if a conflict occurs.
This ensures correctness while pruning invalid paths early.

Input Format:
A char[9][9] Sudoku board
Filled cells contain characters '1' through '9'
Empty cells are represented by '.'
