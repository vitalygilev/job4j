package ru.job4j.array;

public class MatrixCheck {

    public static boolean isWin(char[][] board) {
        boolean result;
        boolean weHaveRowWinner = false;
        String etalon = new String(new char[board.length]).replace("\0", "X");
        int positionOfX = -1;
        for (int index = 1; index < board.length; index++) {
            String value = String.copyValueOf(board[index]);
            if (!weHaveRowWinner) {
                weHaveRowWinner = value.equals(etalon);
            }
            if (positionOfX == -1) {
                positionOfX = value.indexOf("X");
            } else {
                if (positionOfX != value.indexOf("X")) {
                    positionOfX = -2;
                }
            }
            System.out.println(value);
        }
        result = weHaveRowWinner || positionOfX != -2;
        return result;
    }

    public static boolean isWinOld(char[][] board) {
        boolean result;
        int winRowXCounter = 0;
        int winColumnXCounter = 0;
        char sign;
        for (int row = 0; row < board.length; row++) {
            if (winRowXCounter != board.length) {
                winRowXCounter = 0;
            }
            if (winColumnXCounter != board.length) {
                winColumnXCounter = 0;
            }
            for (int cell = 0; cell < board.length; cell++) {
                sign = board[row][cell];
                System.out.print(sign);
                if (sign == 'X') {
                    winRowXCounter += 1;
                }
                sign = board[cell][row];
                if (sign == 'X') {
                    winColumnXCounter += 1;
                }
            }
            System.out.println();
        }
        result = (winRowXCounter == board.length) || (winColumnXCounter == board.length);
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }

}
