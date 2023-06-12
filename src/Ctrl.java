public class Ctrl {
    Puzzle puzzle = new Puzzle();
    View actions = new View();
    public void startGame() {
        actions.printMenu();
        puzzle.fillPuzzleBoard(puzzle.puzzleBoard);
        actions.printPuzzleBoard(puzzle.puzzleBoard, puzzle.rows, puzzle.cols);
        while (!puzzle.isSorted(puzzle.puzzleBoard)) {
            String userInput = actions.userInput();
            if (puzzle.validInput(userInput)) {
                byte[] convertedUserInput = puzzle.convertUserInput(userInput);
//                puzzle.row = convertedUserInput[0];
//                puzzle.col = convertedUserInput[1];
//                puzzle.row2 = convertedUserInput[2];
//                puzzle.col2 = convertedUserInput[3];
                byte [] adress100 = puzzle.numAddress(puzzle.puzzleBoard, (byte) 100);

                if (puzzle.validMove(puzzle.puzzleBoard, convertedUserInput)) {
                    puzzle.updateBoard(puzzle.puzzleBoard,  convertedUserInput[0], convertedUserInput[1], adress100[0], adress100[1]);
                    actions.printPuzzleBoard(puzzle.puzzleBoard, puzzle.rows, puzzle.cols);
                } else {
                    actions.invalidMoveMessage(false);
                }
                puzzle.updateBoard(puzzle.puzzleBoard,  convertedUserInput[0], convertedUserInput[1], adress100[0], adress100[1]);
                actions.printPuzzleBoard(puzzle.puzzleBoard, puzzle.rows, puzzle.cols);
            } else {
                actions.invalidMoveMessage(false);
            }
        }
        actions.printWinMessage(true);
    }
}
