package maze;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MazeGame{
    public static final int HEIGHT = 19;
    public static final int WIDTH = 39;
    private static final int COL = 1;
    private static final int ROW = 0;
    private Scanner playerInput;
    private boolean[][] blocked;
    private boolean[][] visited;
    private int[] player;
    private int[] goal;
    private int[] start;

    public MazeGame(String mazeFile) throws FileNotFoundException
    {
        this(mazeFile, new Scanner(System.in));
    }
    public MazeGame(String mazeFile, Scanner playerInput) throws FileNotFoundException
    {
        this.playerInput = playerInput;
        loadMaze(mazeFile);
    }
    public void playGame()
    {

    }
    public void printMaze()
    {
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                if (blocked[i][j])
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public int getPlayerRow()
    {
        return player[ROW];
    }
    public int getPlayerCol()
    {
        return player[COL];
    }
    public int getGoalRow()
    {
        return goal[ROW];
    }
    public int getGoalCol()
    {
        return goal[COL];
    }
    public int getStartRow()
    {
        return start[ROW];
    }
    public int getStartCol()
    {
        return start[COL];
    }
    public boolean[][] getBlocked()
    {
        return blocked;
    }
    public boolean[][] getVisited()
    {
        return visited;
    }
    public Scanner getPlayerInput()
    {
        return playerInput;
    }

    public void setPlayerRow(int row)
    {
        if ((0 <= row) && (row < WIDTH)){
        player[ROW] = row;}
    }
    public void setPlayerCol(int col)
    {
        if ((0 <= col) && (col < HEIGHT)){
        player[COL] = col;}
    }
    public void setGoalRow(int row)
    {
        if ((0 <= row) && (row < WIDTH)){
        goal[ROW] = row;}
    }
    public void setGoalCol(int col)
    {
        if ((0 <= col) && (col < HEIGHT)){
        goal[COL] = col;}
    }
    public void setStartRow(int row)
    {
        if ((0 <= row) && (row < WIDTH)){
        start[ROW] = row;}
    }
    public void setStartCol(int col)
    {
        if ((0 <= col) && (col < HEIGHT)){
        start[COL] = col;}
    }
    public void setBlocked(boolean[][] blocked)
    {
        this.blocked = copyTwoDimBoolArray(blocked);
    }
    public void setVisited(boolean[][] visited)
    {
        this.visited = copyTwoDimBoolArray(visited);
    }
    public void setPlayerInput(Scanner playerInput)
    {
        this.playerInput = playerInput;
    }
    private boolean[][] copyTwoDimBoolArray(boolean[][] arrayToCopy)
    {
        boolean[][] arrayCopied = new boolean[arrayToCopy.length][arrayToCopy[0].length];
        for (int i = 0; i < arrayToCopy.length; i++)
        {
            for (int j = 0; j < arrayToCopy[i].length; j++)
            {
                arrayCopied[i][j] = arrayToCopy[i][j];
            }
        }
        return arrayCopied;
    }
    private void prompt()
    {
        printMaze();
        System.out.print("Enter your move (up, down, left, right, or q to quit): ");
    }
    private boolean playerAtGoal()
    {
        return (player[ROW] == goal[ROW]) && (player[COL] == goal[COL]);
    }
    private boolean valid(int row, int col)
    {
        if ((row < HEIGHT && 0 <= row) && (col < WIDTH && 0 <= col)){
            return !blocked[row][col];
        }
        return false;
    }
    private void visit(int row, int col)
    {
        visited[row][col] = true;
    }
    private void loadMaze(String mazeFile) throws FileNotFoundException
    {
        blocked = new boolean[HEIGHT][WIDTH];
        visited = new boolean[HEIGHT][WIDTH];
        player = new int[2];
        start = new int[2];
        goal = new int[2];

        Scanner mazeScanner = new Scanner(new FileReader(mazeFile));

        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {   
                String next = mazeScanner.next();
                if (next.equals("1") || next.equals("\n1"))
                {
                    blocked[i][j] = true;
                }
                else if (next.equals("S") || next.equals("\nS"))
                {
                    start[ROW] = i;
                    start[COL] = j;
                    player[ROW] = i;
                    player[COL] = j;
                }
                else if (next.equals("G") || next.equals("\nG"))
                {
                    goal[ROW] = i;
                    goal[COL] = j;
                }
            }
        }
        mazeScanner.close();
    }
    private boolean makeMove(String move)
    {
        // char input = playerInput.nextLine().toLowerCase().charAt(0);
        // int row = player[0];
        // int col = player[1];

        // switch (input) {
        //     case 'u' -> {
        //         if (valid(row+1, col))
        //         {
                    
        //         }
        //         return false;

        //     }
        //     case 'd' -> {
        //         return false;

        //     }
        //     case 'l' -> {
        //         return false;

        //     }
        //     case 'r' -> {
        //         return false;

        //     }
        //     case 'g' -> {
        //         return false;

        //     }
        //     default -> {
        //         return false;
        //     }
        // }
        return false;
    }
}
