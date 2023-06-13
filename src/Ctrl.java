public class Ctrl {
    public void startGame() {
        View.printMenu();
        Puzzle.fillPuzzleBoard(Puzzle.puzzleBoard);
        View.printPuzzleBoard(Puzzle.puzzleBoard, Puzzle.rows, Puzzle.cols);
        while (!Puzzle.isSorted(Puzzle.puzzleBoard)) {
            String userInput = View.userInput();
            if (Puzzle.validInput(userInput)) {
                byte[] convertedUserInput = Puzzle.convertUserInput(userInput);

                byte [] address16 = Puzzle.numAddress(Puzzle.puzzleBoard, (byte) 16);

                if (Puzzle.validMove(Puzzle.puzzleBoard, convertedUserInput)) {
                    Puzzle.updateBoard(Puzzle.puzzleBoard,  convertedUserInput[0], convertedUserInput[1], address16[0], address16[1]);
                    View.printPuzzleBoard(Puzzle.puzzleBoard, Puzzle.rows, Puzzle.cols);
                } else View.invalidMoveMessage(Puzzle.validMove(Puzzle.puzzleBoard, convertedUserInput));
            } else {
                View.invalidMoveMessage(false);
            }
        }
        View.printWinMessage(true);
    }
}
