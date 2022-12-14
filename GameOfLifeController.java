import java.util.Scanner;

public class GameOfLifeController {

        private static GameOfLifeModel model;
        private static GameOfLifeView view;

        public GameOfLifeController(GameOfLifeModel model, GameOfLifeView view) {
                this.model = model;
                this.view = view;
        }
        public static void main(String[] args) {
                System.out.println(" ,-.                           ,              ");
                System.out.println("/                         ,-   |    o  ,-     ");
                System.out.println("| -. ,-: ;-.-. ,-.   ,-.  |    |    .  |  ,-. ");
                System.out.println("|  | | | | | | |-'   | |  |-   |    |  |- |-' ");
                System.out.println(" `-' `-` ' ' ' `-'   `-'  |    `--' '  |  `-' ");
                System.out.println("                         -'           -'      ");
                System.out.println("            IS 247          ");
                System.out.println(" --------------------------- ");

                System.out.println("Enter number of rows: ");
                Scanner rw = new Scanner(System.in);
                int userRow = rw.nextInt();

                System.out.println("Enter number of columns: ");
                Scanner cl = new Scanner(System.in);
                int userColumn = cl.nextInt();


                System.out.println("Enter number of generaton: ");
                Scanner gn = new Scanner(System.in);
                int userGen = gn.nextInt();

                int rows = userRow, cols = userColumn, genMax = userGen;

                System.out.println("Enter Sleep time: ");
                Scanner sleep = new Scanner(System.in);
                long sleepTime = sleep.nextInt();
                String delimiter = " ";
                String delimiterString = "-";


                GameOfLifeModel model = new GameOfLifeModel(rows, cols);
                GameOfLifeView view = new GameOfLifeView(rows, cols);

                Scanner pat = new Scanner(System.in);

                System.out.println(" Enter the number for the pattern you chose 1. Glider 2.Exploder 3.GliderGunPattern  4.Spaceship");
                int patChoice = pat.nextInt();
                if (patChoice == 1) {
                        view.placeGlider(8,4);
                }
                if (patChoice == 2) {
                        view.placeExploder(8, 4);

                }
                if (patChoice == 3) {
                        view.placeGliderGunPattern(8, 8);

                }
                if (patChoice == 4) {
                        view.placeSpaceshipPattern(8, 8);

                }


                char[][] currentGen = view.getGameBoard();

                for (int i = 0; i < currentGen[0].length; i++) {
                        delimiter += delimiterString;
                }
                //57
                System.out.println("Generation 0");
                System.out.println(delimiter);

                model.printGameboard();
                System.out.println(delimiter);
                //67
                char[][] nextGen = new char[rows][cols];

                int genCounter;
                for (genCounter = 1; genCounter <= genMax; genCounter++) {
                        currentGen = view.getGameBoard();

                        for (int r = 0; r < nextGen.length; r++) {
                                for (int c = 0; c < nextGen[0].length; c++) {
                                        nextGen[r][c] = ' ';
                                }
                        }


                        for (int r = 0; r < currentGen.length; r++) {
                                for (int c = 0; c < currentGen[0].length; c++) {
                                        int neighbors = model.getNeighbors(r, c);
                                        //88
                                        if (currentGen[r][c] != '*') {
                                                if (neighbors == 3)
                                                        nextGen[r][c] = '*';
                                        } else {
                                                if (neighbors < 2 || neighbors > 3)
                                                        nextGen[r][c] = ' ';
                                                else
                                                        nextGen[r][c] = '*';
                                        }
                                }


                        }
                        for (int r = 0; r < nextGen.length; r++) {
                                for (int c = 0; c < nextGen[0].length; c++) {
                                        model.setCell(r, c, nextGen[r][c]);
                                }
                        }


                        System.out.println("Generation:" + genCounter);

                        System.out.println(delimiter);
                        model.printGameboard();

                        System.out.println(delimiter);


                        try {
                                Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }

                }


        }
}
