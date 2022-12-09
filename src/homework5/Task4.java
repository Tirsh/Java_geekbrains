package homework5;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {

    }
}
class ChessBoard{
    private byte[][] board;
    private int numberOfQueens;
    private int boardSize;


    public ChessBoard(int size) {
        board = new byte[size][size];
        boardSize = size;
        numberOfQueens = 0;
    }

    public ChessBoard(ChessBoard board) {
        this.board = board.board;
        this.numberOfQueens = board.numberOfQueens;
        this.boardSize = board.boardSize;
    }
    public boolean putQueen(int x, int y){
        if (board[x][y] != 0x0){
            return false;
        }
        board[x][y] = 'q';
        markBoard(x, y);
        return true;
    }
    private void markBoard(int x, int y){

    }
    public boolean checkQueensOnBoard(int number){
        if (numberOfQueens == number) return true;
        else return false;
    }
}