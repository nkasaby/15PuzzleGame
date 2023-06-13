public class Ctrl {
    Puzzle puzzle = new Puzzle();
    View actions = new View();
    public void startGame() {
        View.printMenu();
        Puzzle.fillPuzzleBoard(Puzzle.puzzleBoard);
        View.printPuzzleBoard(Puzzle.puzzleBoard, Puzzle.rows, Puzzle.cols);
        while (!Puzzle.isSorted(Puzzle.puzzleBoard)) {
            String userInput = View.userInput();
            if (Puzzle.validInput(userInput)) {
                byte[] convertedUserInput = Puzzle.convertUserInput(userInput);
//                puzzle.row = convertedUserInput[0];
//                puzzle.col = convertedUserInput[1];
//                puzzle.row2 = convertedUserInput[2];
//                puzzle.col2 = convertedUserInput[3];
                byte [] adress16 = Puzzle.numAddress(Puzzle.puzzleBoard, (byte) 16);

                if (Puzzle.validMove(Puzzle.puzzleBoard, convertedUserInput)==true) {
                    puzzle.updateBoard(Puzzle.puzzleBoard,  convertedUserInput[0], convertedUserInput[1], adress16[0], adress16[1]);
                    View.printPuzzleBoard(Puzzle.puzzleBoard, Puzzle.rows, Puzzle.cols);
                } else View.invalidMoveMessage(Puzzle.validMove(Puzzle.puzzleBoard, convertedUserInput));
               // puzzle.updateBoard(Puzzle.puzzleBoard,  convertedUserInput[0], convertedUserInput[1], adress16[0], adress16[1]);
                View.printPuzzleBoard(Puzzle.puzzleBoard, Puzzle.rows, Puzzle.cols);
            } else {
                View.invalidMoveMessage(false);
            }
        }
        View.printWinMessage(true);
    }
}
