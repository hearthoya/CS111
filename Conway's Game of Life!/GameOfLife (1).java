public class GameOfLife {
    public static void main(String[] args) {
        //request user inputs
        int numCells = Integer.parseInt(args[0]);
        //declare copies of each pattern
        int numCopies = Integer.parseInt(args[1]);
        //declare colors
        int r, g, b;
        //random red value from 1 to 170
        r = (int) (Math.random() * 170);
        //random green value from 1 to 170
        g = (int) (Math.random() * 170);
        //random blue value from 1 to 170
        b = (int) (Math.random() * 170);
        //check amount of user inputs and that user inputs are positive
        if (args.length != 2 || numCopies <= 0 || numCells <= 0) {
            System.err.println("\n Invalid user input, please try again with valid inputs.");
            System.exit(1);
        }
        //make an array of integer arrays and give it dimensions numCells by numCells
        int[][] env = new int[numCells][numCells];
        //set scale + size and enable double buffering (THIS SHOULD GO BELOW YOUR COORDINATE FOR LOOP)
        setDraw(numCells);
        //declare row and column values
        for (int i = 0; i < numCopies; i++) {
            int r1 = ((int) (Math.random() * (numCells)));
            int c1 = ((int) (Math.random() * (numCells)));
            int r2 = ((int) (Math.random() * (numCells)));
            int c2 = ((int) (Math.random() * (numCells)));
            int r3 = ((int) (Math.random() * (numCells)));
            int c3 = ((int) (Math.random() * (numCells)));
            //method for initializing patterns with env and coordinates
            glider(env, r1, c1);
            blinker(env, r2, c2);
            lwss(env, r3, c3);
        }
        //noinspection InfiniteLoopStatement
        while (true) {
            //apply the rules
            env = applyRules(numCells, env);
            //draw next state
            drawPat(env, numCells, r, g, b);
        }
    }
    //method for setting StdDraw
    public static void setDraw(int numCells) {
        //set draw scale to num cells
        StdDraw.setScale(0, numCells);
        //turn on double buffering
        StdDraw.enableDoubleBuffering();
    }
    //method for initializing glider in array
    public static void glider(int[][] env, int r1, int c1) {
        //starting block (on bottom right)
        env[(r1 + env.length) % env.length][(c1 + env.length) % env.length] = 1;
        //up one block
        env[((r1 + env.length) % env.length)][(((c1 + 1) + env.length) % env.length)] = 1;
        //up two blocks
        env[((r1 + env.length) % env.length)][(((c1 + 2) + env.length) % env.length)] = 1;
        //left one block
        env[((r1 - 1) + env.length) % env.length][(c1 + env.length) % env.length] = 1;
        //left two blocks + up one block
        env[((r1 - 2) + env.length) % env.length][(((c1 + 1) + env.length) % env.length)] = 1;
    }
    public static void blinker(int[][] env, int r2, int c2) {
        //starting block
        env[(r2 + env.length) % env.length][(c2 + env.length) % env.length] = 1;
        //left one block
        env[((r2 - 1) + env.length) % env.length][(c2 + env.length) % env.length] = 1;
        //right one block
        env[((r2 + 1) + env.length) % env.length][(c2 + env.length) % env.length] = 1;
    }
    public static void lwss(int[][] env, int r3, int c3) {
        //start block (left corner)
        env[(r3 + env.length) % env.length][(c3 + env.length) % env.length] = 1;
        //up one block
        env[(r3 + env.length) % env.length][(c3 + 1 + env.length) % env.length] = 1;
        //up two blocks
        env[(r3 + env.length) % env.length][(c3 + 2 + env.length) % env.length] = 1;
        //up three right one
        env[(r3 + 1 + env.length) % env.length][(c3 + 3 + env.length) % env.length] = 1;
        //up three right four
        env[(r3 + 4 + env.length) % env.length][(c3 + 3 + env.length) % env.length] = 1;
        //up two right four
        env[(r3 + 4 + env.length) % env.length][(c3 + 3 + env.length) % env.length] = 1;
        //up one right four
        env[(r3 + 4 + env.length) % env.length][(c3 + 1 + env.length) % env.length] = 1;
        //right one
        env[(r3 + 1 + env.length) % env.length][(c3 + env.length) % env.length] = 1;
        //right two
        env[(r3 + 2 + env.length) % env.length][(c3 + env.length) % env.length] = 1;
        //right three
        env[(r3 + 3 + env.length) % env.length][(c3 + env.length) % env.length] = 1;
    }
    public static void drawPat(int[][] env, int numCells, int r, int g, int b) {
        //reset canvas at the start of each frame
        StdDraw.clear();
        //checks each row and column coordinate
        for (int rows = 0; rows < numCells; rows++) {
            for (int cols = 0; cols < numCells; cols++) {
                //Draws a square if the position has state 1.
                if (env[rows][cols] == 1) {
                    StdDraw.setPenColor(r, g, b);
                    StdDraw.filledSquare(rows, cols, .51);
                }
            }
        }
        StdDraw.show();
        //refresh every 49 ms
        StdDraw.pause(49);
    }
    public static int[][] applyRules(int numCells, int[][] env) {
        //create new/next env
        int[][] nextEnv = new int[numCells][numCells];
        for (int rows = 0; rows < numCells; rows++) {
            for (int cols = 0; cols < numCells; cols++) {
                //check each row and col/coordinate for state to count neighbors
                int ncounter = 0;
                //right one cell
                if (env[(rows + 1 + env.length) % env.length][(cols + env.length) % env.length] == 1) {
                    ncounter++;
                }
                //right one cell up one cell
                if (env[(rows + 1 + env.length) % env.length][(cols + 1 + env.length) % env.length] == 1) {
                    ncounter++;
                }
                //up one cell
                if (env[(rows + env.length) % env.length][(cols + 1 + env.length) % env.length] == 1) {
                    ncounter++;
                }
                //up one cell and left one cell
                if (env[(rows - 1 + env.length) % env.length][(cols + 1 + env.length) % env.length] == 1) {
                    ncounter++;
                }
                //left one cell
                if (env[(rows - 1 + env.length) % env.length][(cols + env.length) % env.length] == 1) {
                    ncounter++;
                }
                //left one cell and down one cell
                if (env[(rows - 1 + env.length) % env.length][(cols - 1 + env.length) % env.length] == 1) {
                    ncounter++;
                }
                //down one cell
                if (env[(rows + env.length) % env.length][(cols - 1 + env.length) % env.length] == 1) {
                    ncounter++;
                }
                //down one cell and right one cell
                if (env[(rows + 1 + env.length) % env.length][(cols - 1 + env.length) % env.length] == 1) {
                    ncounter++;
                }
                //if there are two or three neighbors a living cell lives on
                if (env[rows][cols] == 1 && ((ncounter == 3) || ncounter == 2)) {
                    nextEnv[rows][cols] = 1;
                }
                //any dead cell with three neighbors becomes a living cell
                if (env[rows][cols] == 0 && ncounter == 3) {
                    nextEnv[rows][cols] = 1;
                }
            }
        }
        //return new environment
        return nextEnv;
    }
}