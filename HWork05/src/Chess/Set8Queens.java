package Chess;

public class Set8Queens {

    static int[] chessBoard = { 0, 0, 0, 0, 0, 0, 0, 0 };// indexes - horizontal, values - vertical
    static int index = 0; //rows
    static int version = 0;//number of good combination's version 

    public static void setQueens() {

        do {
            if (checkLines()) {
                if (index == 7) {// new version completed
                    version++;
                    printVersion(chessBoard, version);
                    chessBoard[index]++;
                } else {// goes to next queen to find a place
                    index++;
                }
            } else {
                chessBoard[index]++;// goes to next column
            }
        } while (chessBoard[0] < 8);
    }

    private static boolean checkLines() {// checks the queens are not in the same column & diagonal
        int i;

        if (index == 0) {// first queen is always in place!
            return true;
        }

        if (chessBoard[index] > 7) {// board column roll-over
            chessBoard[index] = 0;
            index--;
            return false;
        }

        for (i = 0; i < index; i++) {
            if ((chessBoard[index] == chessBoard[i]) | // the same board column - bad!
                    ((Math.abs(chessBoard[index] - chessBoard[i])) == (index - i))) // the same diagonal
            {
                return false;
            }
        }

        return true;
    }

    private static void printVersion(int[] board, int version) {
        System.out.println("No " + version + " (row-column):\t1-" + (board[0] + 1) + ", 2-" + (board[1] + 1) + ", 3-"
                + (board[2] + 1) + ", 4-" + (board[3] + 1) + ", 5-" + (board[4] + 1) + ", 6-"
                + (board[5] + 1) + ", 7-" + (board[6] + 1) + ", 8-" + (board[7] + 1));
    }
}
