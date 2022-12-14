
public class GameOfLifeView implements GameView{
    private static int rows;
    private static int columns;
    //private int generations;
    public static char[][] gameBoard;

   private  char[][] gliderPattern =
            {{' ', '*', ' '},
                    {' ', ' ', '*'},
                    {'*', '*', '*'}};
    private char[][] ExploderPattern =
            {{' ', '*', ' '},
                    {'*', '*', '*'},
                    {'*', ' ', '*'},
                    {' ', '*', ' '}};
    private char[][] SpaceshipPattern =
            {{' ', '*', '*','*','*'},
                    {'*',' ', ' ',' ','*'},
                    {' ',' ', ' ',' ','*'},
                    {'*',' ', ' ','*',' '},};
    private char[][] GliderGunPattern =
            {{' ', ' ',' ',' ' ,' ',' ',' ', ' ','*','*',' ',' ' ,' ',' ',' ', ' ',' ',' ' ,' ','*','*'},
                    {' ',' ' ,' ','*',' ','*',' ',' ',' ',' ' ,' ',' ',' ', ' ',' ',' ' ,' ','*','*'},
                    {'*','*',' ',' ','*','*',' ',' ' ,' ',' ','*', '*',' ', ' ',' ',' ' ,' ',' ',' '},
                    {'*','*',' ',' ','*',' ','*',' ',' ',' ',' ',' ',' ',' ', ' ',' ',' ',' ',' ',' '},
                    {' ',' ' ,' ','*','*', ' ',' ','*','*',' ',' ', ' ','*','*',' ',' ' ,' ',' ',' '},
                    {' ', ' ',' ','*' ,' ','*',' ', ' ','*','*',' ',' ' ,' ',' ',' ', ' ',' '},
                    {' ',' ' ,' ',' ',' ', ' ',' ','*' ,' ',' ',' ', ' ',' ',' ',' ',' ' ,' '},
                    {' ',' ' ,' ',' ',' ', ' ',' ','*' ,' ',' ',' ', ' ',' ',' ',' ', ' ',' ',' ' ,' ','*','*'},
                    {' ',' ' ,' ',' ',' ', ' ',' ','*' ,' ',' ',' ', ' ',' ',' ',' ', ' ',' ',' ' ,'*',' ','*'},
                    {' ',' ' ,' ',' ',' ', ' ',' ','*' ,' ',' ',' ', ' ',' ',' ',' ', ' ',' ',' ' ,'*',' ',' '},
                    {' ',' ' ,' ',' ',' ', ' ',' ',' ' ,' ','*','*', '*',' ',' ',' ',' ',' ' ,' ',' ' ,' '},
                    {' ',' ' ,' ',' ',' ', ' ',' ',' ' ,' ','*',' ', ' ',' ',' ',' ',' ' ,' ',' ',' ', ' ',' ',},
                    {' ',' ' ,' ',' ',' ', ' ',' ',' ' ,' ',' ','*', ' ',' ',' ',' ',' ' ,' ',' ',' ', ' ',' ',}};

    public GameOfLifeView(int r, int c) {
                        this.rows = r;
                        this.columns = c;
                        gameBoard = new char[rows][columns];

                        for (int row = 0; row < gameBoard.length; row++) {
                            for (int col = 0; col < gameBoard.length; col++) {
                                gameBoard[row][col] = ' ';
                            }
                        }
                    }
    public void placeGlider ( int r, int c){
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                gameBoard[r + i][c + j] = gliderPattern[1 + i][1 + j];
            }
        }
    }

    public void placeExploder(int r, int c) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                gameBoard[r + i][c + j] = ExploderPattern[1 + i][1 + j];
            }
        }
    }
    public void placeGliderGunPattern(int r, int c) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                gameBoard[r + i][c + j] = GliderGunPattern[1 + i][1 + j];
            }
        }
    }
    public void placeSpaceshipPattern(int r, int c) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                gameBoard[r + i][c + j] = SpaceshipPattern[1 + i][1 + j];
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

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


}
    
