
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
public class Puzzle {
    public static char[] cols = new char[]{'a', 'b', 'c', 'd'};
    public static byte[] rows = new byte[]{1, 2, 3, 4};
    static byte[][] puzzleBoard = new byte[4][4];
    static Vector<Byte> usedNums = new Vector<>();

    public static void fillPuzzleBoard(byte[][] puzzleBoard) {
        Random num = new Random();
        // byte computerPosition = (byte) (computerPositionChoice.nextInt(9) + 1);
        for (byte i = 0; i < 4; i++) {
            for (byte j = 0; j < 4; j++) {

                do {
                    puzzleBoard[i][j] = (byte) (num.nextInt(16));
                } while (usedNums.contains(puzzleBoard[i][j]));

                usedNums.add(puzzleBoard[i][j]);

                if (puzzleBoard[i][j] == 0) {
                    puzzleBoard[i][j] = 100;
                }
            }
        }
    }
    public static boolean isSorted (byte[][] puzzleBoard) {
        byte previous = puzzleBoard[0][0];

        for (byte i = 0; i < puzzleBoard.length; i++) {
            for (byte j = 0; j < puzzleBoard[i].length; j++) {
                if (puzzleBoard[i][j] < previous) {
                    return false;
                }
                previous = puzzleBoard[i][j];
            }
        }
        return true;
    }
    public static boolean validInput(String userInput) {
        if (userInput.length() != 2) {
            return false;
        }
        char col = userInput.charAt(0);
        byte row = Byte.parseByte(userInput.substring(1));
        if (col < 'a' || col > 'd') {
            return false;
        }
        if (row < 1 || row > 4) {
            return false;
        }
        return true;
    }

    public static byte[] convertUserInput(String userInput) {
        byte[] convertedUserInput = new byte[2];
        char col = userInput.charAt(0);
        byte row = Byte.parseByte(userInput.substring(1));
        convertedUserInput[0] = (byte) (col - 'a');
        convertedUserInput[1] = (byte) (row - 1);
        return convertedUserInput;
    }

    public byte[][] updateBoard(byte[][] puzzleBoard, byte i, byte j, byte k, byte l){
        byte[][] newBoard = puzzleBoard;
        byte temp = newBoard[i][j];
        newBoard[i][j] = newBoard[k][l];
        newBoard[k][l] = temp;
        return newBoard;
    }

    public static byte[] numAddress (byte[][] puzzleBoard, byte num) {
        byte[] address = new byte[2];
        for (byte i = 0; i < 4; i++) {
            for (byte j = 0; j < 4; j++) {
                if (puzzleBoard[i][j] == num) {
                    address[0] = i;
                    address[1] = j;
                }
            }
        }
        return address;
    }

    public static boolean validMove(byte[][] puzzleBoard, byte[] convertedUserInput) {
        byte[] adress100 = numAddress(puzzleBoard, (byte) 100);
        System.out.println(Arrays.toString(adress100));

        byte[] adressUserInput = numAddress(puzzleBoard, (byte) convertedUserInput[0]);

        if (adressUserInput[0] == adress100[0] && adressUserInput[1] == adress100[1] + 1) {
            return true;
        }
        if (adressUserInput[0] == adress100[0] && adressUserInput[1] == adress100[1] - 1) {
            return true;
        }
        if (adressUserInput[0] == adress100[0] + 1 && adressUserInput[1] == adress100[1]) {
            return true;
        }
        if (adressUserInput[0] == adress100[0] - 1 && adressUserInput[1] == adress100[1]) {
            return true;
        }
        return false;
    }


}
