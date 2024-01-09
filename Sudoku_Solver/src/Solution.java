import java.util.HashMap;

public class Solution {
	//given any valid sudoku board this program will solve it and print out the solution.
	public void solveSudoku(char[][] board) {
		HashMap<String, String> sudoku = new HashMap<String, String>();
		sudoku.put("subbox1", "");
		sudoku.put("subbox2", "");
		sudoku.put("subbox3", "");
		sudoku.put("subbox4", "");
		sudoku.put("subbox5", "");
		sudoku.put("subbox6", "");
		sudoku.put("subbox7", "");
		sudoku.put("subbox8", "");
		sudoku.put("subbox9", "");
		sudoku.put("row1", "");
		sudoku.put("row2", "");
		sudoku.put("row3", "");
		sudoku.put("row4", "");
		sudoku.put("row5", "");
		sudoku.put("row6", "");
		sudoku.put("row7", "");
		sudoku.put("row8", "");
		sudoku.put("row9", "");
		sudoku.put("col1", "");
		sudoku.put("col2", "");
		sudoku.put("col3", "");
		sudoku.put("col4", "");
		sudoku.put("col5", "");
		sudoku.put("col6", "");
		sudoku.put("col7", "");
		sudoku.put("col8", "");
		sudoku.put("col9", "");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					sudoku.put(("row" + (i + 1)), sudoku.get("row" + (i + 1)) + board[i][j]);
					sudoku.put(("col" + (j + 1)), sudoku.get("col" + (j + 1)) + board[i][j]);
					sudoku.put(("subbox" + (((i / 3) * 3) + 1 + (j / 3))),
							sudoku.get("subbox" + (((i / 3) * 3) + 1 + (j / 3))) + board[i][j]);
				}
			}
		}
		recursiveSudoku(board, sudoku);
	}

	public boolean recursiveSudoku(char[][] board, HashMap<String, String> sudoku) {
		int row = -1;
		int col = -1;
		first: for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					row = i;
					col = j;
					break first;
				}
			}
		}
		if (row == -1 && col == -1) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.println(board[i][j]);
				}
			}
			return true;
		}
		String rowString = sudoku.get("row" + (row + 1));
		String colString = sudoku.get("col" + (col + 1));
		String subboxString = sudoku.get("subbox" + (((row / 3) * 3) + 1 + (col / 3)));
		for (int k = 1; k < 10; k++) {
			if (!(rowString.contains("" + k)) && !(colString.contains("" + k)) && !(subboxString.contains("" + k))) {

				board[row][col] = (char) (k + 48);
				sudoku.put(("row" + (row + 1)), rowString + k);
				sudoku.put(("col" + (col + 1)), colString + k);
				sudoku.put(("subbox" + (((row / 3) * 3) + 1 + (col / 3))), subboxString + k);

				if (recursiveSudoku(board, sudoku)) {
					return true;
				} else {
					board[row][col] = '.';
					sudoku.put(("row" + (row + 1)), rowString);
					sudoku.put(("col" + (col + 1)), colString);
					sudoku.put(("subbox" + (((row / 3) * 3) + 1 + (col / 3))), subboxString);
				}
			}
		}
		return false;
	}
}
