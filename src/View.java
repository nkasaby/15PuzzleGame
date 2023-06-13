import java.util.Scanner;

public class View {


    public static void printMenu() {
        System.out.println("Welcome to the 15 Puzzle Game!");
        System.out.println("Your aim is to place the tiles in numerical order 1-15 by moving them vertically or horizontally using the empty space.");
        System.out.println("You should enter your desired move in the following format: a4 where a is the column and 4 is the row.");
    }
    public static String userInput() {
        System.out.println();
        System.out.print("Enter your move: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public static void printPuzzleBoard (byte [][] puzzleBoard, byte []  rows, char [] cols) {
        System.out.println();

        for (byte i = 0; i < 4; i++) {
            for (byte j = 0; j < 4; j++) {
                if (puzzleBoard[i][j] == 16 ) {
                    System.out.printf("%-4s"," ");
                }
                else
                   System.out.printf("%-4d",puzzleBoard[i][j]);
            }
            System.out.print( " | " + rows[i]);
            System.out.println();
        }
        System.out.println("--  --  --  --");


        for (byte i = 0; i < 4; i++)
        {

            System.out.print( cols[i] + "   ");
        }
    }
    public static void printWinMessage(boolean win) {
        System.out.println("Congratulations! You won!");
    }
    public static void invalidMoveMessage(boolean valid) {
        System.out.println("Invalid move! Try again!");
    }

}
