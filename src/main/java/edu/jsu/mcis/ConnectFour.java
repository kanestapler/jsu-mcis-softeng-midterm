package edu.jsu.mcis;

public class ConnectFour {
    public enum Location {EMPTY, RED, BLACK};
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private Location[][] board = new Location[ROWS][COLUMNS];
    private Location turn;
    
    public ConnectFour() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = Location.EMPTY;
            }
        }
        turn = Location.RED;
    }
    
    public Location getTopOfColumn(int column) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][column] == Location.EMPTY) {
                
            } else {
                return board[i][column];
            }
        }
        return Location.EMPTY;
    }
    
    public int getHeightOfColumn(int column) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][column] != Location.EMPTY) {
                return (ROWS-i);
            }
        }
        return 0;
    }
    
    public void dropToken(int column) {
        if (getHeightOfColumn(column) == ROWS) {
            throw new ColumnFullException("");
        }
        int row = (ROWS - getHeightOfColumn(column) - 1);
        board[row][column] = turn;
        flipTurn();
    }
    
    public class ColumnFullException extends RuntimeException {
        public ColumnFullException(String msg){
            super(msg);
        }
    }
    
    private void flipTurn() {
        if (turn == Location.BLACK) {
            turn = Location.RED;
        } else {
            turn = Location.BLACK;
        }
    }
}