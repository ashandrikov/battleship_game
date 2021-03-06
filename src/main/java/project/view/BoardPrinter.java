package project.view;

import project.model.Player;

import static project.utils.Constants.*;

public class BoardPrinter {

    public static synchronized void showBoards(Player player) {
        int[][] myField = player.getMyBoard().getBoard();
        int[][] enemyField = player.getMyShots().getBoard();
        showHeader(player);
        for (int i = 0; i < 10; i++) {
            System.out.format("%3d", i + 1);
            for (int j = 0; j < 23; j++) {
                if (j < 10) {
                    switch (myField[i][j]) {
                        case 0:
                            System.out.printf("  %s", WAVE);
                            break;
                        case 1:
                            System.out.printf("  %s", "W");
                            break;
                        case 2:
                            System.out.printf("  %s", MISS);
                            break;
                        case 3:
                            System.out.printf("  %s", HIT);
                            break;
                        default:
                    }
                } else if (j < 12) {
                    System.out.print("\t");
                } else if (j == 12) {
                    System.out.printf("%3d", i + 1);
                } else {
                    switch (enemyField[i][j - 13]) {
                        case 0:
                            System.out.printf("  %s", WAVE);
                            break;
                        case 2:
                            System.out.printf("  %s", MISS);
                            break;
                        case 3:
                            System.out.printf("  %s", HIT);
                            break;
                        default:
                    }
                }
            }
            System.out.println();
        }
    }

    public static void showHeader(Player player) {
        System.out.println();
        System.out.println("\t\t\t\t\t\tMY BOARD (" + player.getName() + ") vs ENEMY BOARD");
        System.out.println();
        showHighLine();
        System.out.print("\t\t");
        showHighLine();
        System.out.println();
    }

    public static void showHighLine() {
        System.out.print("\t");
        for (int i = 0; i < 10; i++) {
            System.out.format("%3s", (char) (i + 65) + " ");
        }
    }
}
