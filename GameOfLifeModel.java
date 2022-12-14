public class GameOfLifeModel implements GameModel{
        public char[][] gameBoard;
        private int row;
        private int columns;


        public GameOfLifeModel(int r, int c) {
            this.row = r;
            this.columns = c;
            gameBoard = new char[row][columns];

            for (int row = 0; row < gameBoard.length; row++) {
                for (int col = 0; col < gameBoard.length; col++) {
                    gameBoard[row][col] = ' ';
                }
            }
        }

        public void printGameboard() {
            for (int r = 0; r < gameBoard.length; r++) {
                for (int c = 0; c < gameBoard.length; c++) {
                    System.out.print(gameBoard[r][c]);
                }
                System.out.println("");
            }
        }


        public void setCell(int r, int c, char ch) {
            gameBoard[r][c] = ch;
        }

        public char[][] getGameBoard() {
            return gameBoard;
        }

        public int getNeighbors(int r, int c) {
            int neighbors = 0;
            if ((r + 1) != gameBoard.length && (c - 1) != -1
                    && gameBoard[r + 1][c - 1] == '*') ;
            {
                ++neighbors;
            }
            if ((r + 1) != gameBoard.length && gameBoard[r + 1][c] == '*') {
                ++neighbors;
            }
            //101

            if ((r + 1) != gameBoard.length && (c + 1) != gameBoard.length
                    && gameBoard[r + 1][c + 1] == '*') ;
            {
                ++neighbors;

            }
            if ((c - 1) != -1 && gameBoard[r][c - 1] == '*') {
                ++neighbors;
            }
            if ((c + 1) != gameBoard.length && gameBoard[r][c + 1] == '*') {
                ++neighbors;
            }
            if ((r - 1) != -1 && (c - 1) != -1 && gameBoard[r - 1][c - 1] == '*') {
                ++neighbors;
            }
            if ((r - 1) != -1 && gameBoard[r - 1][c] == '*') {
                ++neighbors;
            }
            if ((r - 1) != -1 && (c + 1) != gameBoard.length && gameBoard[r - 1][c + 1] == '*') {
                ++neighbors;
            }

            return neighbors;
        }


    }




