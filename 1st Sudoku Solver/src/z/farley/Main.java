package z.farley;

public class Main {


    public static void main(String[] args) {
	// write your code here
        solve();
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isLegal(int x, int y, int val, int[][] board) {

        for (int i = 0; i < 9; i++) {           // checks if same row
            if (board[x][i] == val) return false;
        }

        for (int i = 0; i < 9; i++) {           // checks if same column
            if (board[i][y] == val) return false;
        }

        for (int i = x - (x % 3); i <  (((x/3)+1) *3) ; i++) {           // checks box
            for (int j = (y - (y % 3)) ; j < (((y/3)+1) *3) ; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
    }

    static boolean isZeros(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void solve() {
        int[][] board = {{0,0,0,1,9,0,0,0,0},
                        {0,0,0,0,3,5,6,0,4},
                        {3,6,0,0,0,4,0,0,7},
                        {0,0,6,4,8,0,0,0,0},
                        {5,4,0,9,0,0,0,0,0},
                        {0,2,3,5,0,0,0,4,9},
                        {0,3,7,0,5,9,0,1,8},
                        {0,5,0,0,4,0,9,7,0},
                        {0,0,4,0,7,8,3,0,0}};


                     /*   {{0 ,8 ,0 ,0 ,2 ,4 ,0, 3, 0},
                        {0 ,0 ,0 ,0 ,3 ,6 ,7 ,0 ,8},
                        {0, 0, 0, 9, 0, 0, 4, 5, 1},
                        {0, 0, 8, 0, 0, 0, 1, 0, 0},
                        {0, 7, 2, 0, 5, 1, 0, 8, 6},
                        {0, 0, 0, 8, 0, 0, 0, 9, 0},
                        {0, 9, 0, 0, 0, 7, 0, 1, 0},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0},
                        {2, 6, 1, 3, 0, 9, 0, 7, 4}};*/


        if (solver(0,0,board)) {

        } else {
            System.out.println("NO AVAILABLE SOLUTION");

        }
        printBoard(board);


    }

    static boolean solver(int x, int y, int[][] board) {

        if (isZeros(board)) return true;

        if (board[x][y] == 0) {

            for (int i = 1; i < 10; i++) {
                if (isLegal(x,y,i,board)) {
                    board[x][y] = i;

                    if (y == 8) {
                        if (solver(x+1,0,board)) return true;

                    } else {
                        if (solver(x,y+1,board)) return true;

                    }
                }
            }
            board[x][y] = 0;   // "wait" moment

        } else {

            if (y == 8) {
                if (solver(x+1,0,board)) return true;

            } else {
                if (solver(x,y+1,board)) return true;

            }

        }



        return false;
    }
}
/*

public class Main {

    public static void main(String[] args) {
	// write your code here
        solve();
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isLegal(int x, int y, int val, int[][] board) {

        for (int i = 0; i < 9; i++) {           // checks if same row
            if (board[x][i] == val) return false;
        }

        for (int i = 0; i < 9; i++) {           // checks if same column
            if (board[i][y] == val) return false;
        }

        for (int i = x - (x % 3); i <  (((x/3)+1) *3) ; i++) {           // checks box
            for (int j = (y - (y % 3)) ; j < (((y/3)+1) *3) ; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
    }

    static void solve() {
        int[][] board = {{0 ,8 ,0 ,0 ,2 ,4 ,0, 3, 0},
                        {0 ,0 ,0 ,0 ,3 ,6 ,7 ,0 ,8},
                        {0, 0, 0, 9, 0, 0, 4, 5, 1},
                        {0, 0, 8, 0, 0, 0, 1, 0, 0},
                        {0, 7, 2, 0, 5, 1, 0, 8, 6},
                        {0, 0, 0, 8, 0, 0, 0, 9, 0},
                        {0, 9, 0, 0, 0, 7, 0, 1, 0},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0},
                        {2, 6, 1, 3, 0, 9, 0, 7, 4}};


        if (solver(0,0,board)) {

        } else {
            System.out.println("NO AVAILABLE SOLUTION");

        }
        printBoard(board);

    }

    static boolean solver(int x, int y, int[][] board) {

        if (x == 8 && y == 8) {
            return true;
        }

        if (board[x][y] == 0) {

            for (int i = 1; i < 10; i++) {
                if (isLegal(x,y,i,board)) {
                    board[x][y] = i;
                    if (y == 8) {
                        if (solver(x+1,0,board)) return true;

                    } else {
                        if (solver(x,y+1,board)) return true;

                    }
                }
            }

        } else {

            if (y == 8) {
                if (solver(x+1,0,board)) return true;

            } else {
                if (solver(x,y+1,board)) return true;

            }

        }

        return false;
    }

}
 */