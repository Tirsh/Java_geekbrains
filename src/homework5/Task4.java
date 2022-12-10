package homework5;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(8);
        while(!chessBoard.checkQueensOnBoard(8)){
            if(!chessBoard.queenRandomPut())
                chessBoard.clearChessBoard();
        }
        System.out.println("Placing queens by random placement, before result.");
        System.out.println(chessBoard);
    }
}
class ChessBoard{
    private char[][] board;
    private int numberOfQueens;
    private final int boardSize;


    public ChessBoard(int size) {
        board = new char[size][size];
        boardSize = size;
        numberOfQueens = 0;
    }

    public boolean putQueen(int x, int y){
        if (board[x][y] != 0){
            return false;
        }
        markBoard(x, y);
        board[x][y] = 'Q';
        numberOfQueens++;
        return true;
    }
    private void markBoard(int x, int y){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (x == i || y == j || (x-y) == (i-j) || (x+y) == (i+j))
                    board[i][j] = 'x';
            }
        }
    }
    public boolean checkQueensOnBoard(int number){
        return numberOfQueens == number;
    }
    public boolean queenRandomPut(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == 0){
                    stringBuilder.append(String.format("%d:%d ", i, j));
                }
            }
        }
        if(stringBuilder.isEmpty()) return false;
        String[] freeCells = stringBuilder.toString().strip().split("\\s");
        int x = Integer.parseInt(freeCells[random.nextInt(freeCells.length)].split(":")[0]);
        int y = Integer.parseInt(freeCells[random.nextInt(freeCells.length)].split(":")[1]);
        return putQueen(x,y);
    }
    public void clearChessBoard(){
        board = new char[boardSize][boardSize];
        numberOfQueens = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] line:board) {
            stringBuilder.append(Arrays.toString(line));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}