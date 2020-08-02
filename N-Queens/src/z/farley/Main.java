package z.farley;



public class Main {

    int N = 16;


    public static void main(String[] args) {
	// write your code here
        solve();
    }

    static void solve() {

        int[][] board = new int[N][N];


        if (solver(board,0,0)) {
            printBoard(board);
        } else {
            System.out.println("NO POSSIBLE SOLUTION");
        }
    }

    static boolean isValid(int x, int y, int[][] board) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < y; i++)
            if (board[x][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = x, j = y; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = x, j = y; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean solver(int[][] board, int x, int y) {

        if (y >= N) {
            return true;
        }


        for (int i = 0; i < N; i++) {

            if (isValid(i,y,board)) {

                board[i][y] = 1;

                if (solver(board, 0, y+1)) {
                    return true;
                }

                board[i][y] = 0;

            }

        }

        return false;
    }


}
