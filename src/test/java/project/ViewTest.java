package project;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import project.boards.MyBoard;
import project.model.Player;
import project.model.Point;
import project.model.Ship;
import project.model.Shot;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static project.service.inputs.InputShooterReader.putOnBoard;
import static project.view.BoardPrinter.showBoards;

class ViewTest extends UnitBase {

    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    private static final String MISS = GREEN + "0" + RESET;
    private static final String HIT = RED + "X" + RESET;
    private static final String WAVE = CYAN + "~" + RESET;

    MyBoard myBoard;
    MyBoard myShots;
    Player player1;

    @Test
    void testBoardPrinterEmptyBoard() {
        createPlayers();
        player1.setName("Tom");

        showBoards(player1);
        String expected = "MY BOARD (Tom) vs ENEMY BOARD\n" + "\n" +
                "\t A  B  C  D  E  F  G  H  I  J \t\t\t A  B  C  D  E  F  G  H  I  J \n" +
                "  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                " 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";

        assertEquals(expected, getOutput().replace(WAVE, "~").replaceAll("\r", ""));
    }

    @Test
    void testBoardPrinterShipPlacer() {
        createPlayers();

        Ship ship1 = new Ship(Arrays.asList(new Point(0, 1), new Point(1, 1)));
        myBoard.placeShip(ship1);

        showBoards(player1);
        String expected = "MY BOARD (null) vs ENEMY BOARD\n" + "\n" +
                "\t A  B  C  D  E  F  G  H  I  J \t\t\t A  B  C  D  E  F  G  H  I  J \n" +
                "  1  ~  W  ~  ~  ~  ~  ~  ~  ~  ~\t\t  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  2  ~  W  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                " 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";

        assertEquals(expected, getOutput().replace(WAVE, "~").replaceAll("\r", ""));
    }

    @Test
    void testBoardPrinterMyShots() {
        createPlayers();

        putOnBoard(myShots, new Point(0, 0), Shot.MISS);
        putOnBoard(myShots, new Point(1, 1), Shot.HIT);
        putOnBoard(myShots, new Point(2, 2), Shot.KILLED);

        showBoards(player1);
        String expected = "MY BOARD (null) vs ENEMY BOARD\n" + "\n" +
                "\t A  B  C  D  E  F  G  H  I  J \t\t\t A  B  C  D  E  F  G  H  I  J \n" +
                "  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  1  0  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  X  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  3  ~  ~  X  ~  ~  ~  ~  ~  ~  ~\n" +
                "  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                " 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";

        assertEquals(expected, getOutput()
                .replace(WAVE, "~")
                .replace(MISS, "0")
                .replace(HIT, "X")
                .replaceAll("\r", ""));

    }

    @Test
    void testBoardPrinterEnemyShots() {
        createPlayers();

        putOnBoard(myBoard, new Point(0, 1), Shot.MISS);
        putOnBoard(myBoard, new Point(0, 2), Shot.HIT);
        putOnBoard(myBoard, new Point(0, 3), Shot.KILLED);

        showBoards(player1);
        String expected = "MY BOARD (null) vs ENEMY BOARD\n" + "\n" +
                "\t A  B  C  D  E  F  G  H  I  J \t\t\t A  B  C  D  E  F  G  H  I  J \n" +
                "  1  ~  0  X  X  ~  ~  ~  ~  ~  ~\t\t  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                " 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";

        assertEquals(expected, getOutput()
                .replace(WAVE, "~")
                .replace(MISS, "0")
                .replace(HIT, "X")
                .replaceAll("\r", ""));
    }

    private void createPlayers() {
        myBoard = new MyBoard();
        myShots = new MyBoard();
        player1 = new Player(myBoard, myShots);
    }

}
