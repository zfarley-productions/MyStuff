package z.farley;

public class Main {

    public static void main(String[] args) {
	// write your code here
        solve();
    }

    static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < 8 && y >= 0 && y < 8 && sol[x][y] == -1);
    }

    static void printBoard(int[][] sol) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solve() {
        int[][] sol = new int[8][8];   // board initialised

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sol[i][j] = -1;            // all boxes set to empty "-1"
            }
        }

        sol[0][0] = 0;   // start journey at 0

        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};   // all possible moves for the knight in the x and y directions
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        if (solver(0,0,1,sol,xMove,yMove)) {     // begins journey at 0,0 coordinate on move 1
            printBoard(sol);
        } else {
            System.out.println("NO SOLUTION AVAILABLE");
        }

    }

    static boolean solver(int x, int y, int moveI, int[][] sol, int[] xMove, int yMove[]) {

        int new_x, new_y;  // new candidate coordintes

        if (moveI == 64) {
            return true;     // reached a solution now return true back up the chain
        }

        for (int i = 0; i < 8; i++) {
            new_x = x + xMove[i];      // tries each new move
            new_y = y + yMove[i];
            if (isSafe(new_x, new_y, sol)) {   // if each move is valid (both on the board and unvisited) 
                sol[new_x][new_y] = moveI;     // set path to new move
                if (solver(new_x, new_y, moveI+ 1,sol, xMove, yMove)) {   // recurvively goes and finds path
                    return true;
                }
                sol[new_x][new_y] = -1;   // backtracks, resets and looks for new move
            }

        }

        return false;  // if no valid path available with candidate roots return false, this will backtrack 
    }
}

// yee yee