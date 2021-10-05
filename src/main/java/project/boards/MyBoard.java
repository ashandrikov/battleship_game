package project.boards;


import project.model.Point;
import project.model.Ship;

import java.util.List;

public class MyBoard extends Board {

    public void placeShip(Ship ship) {
        List<Point> coordinates = ship.getCoordinates();
        for (Point point : coordinates) {
            board[point.getX()][point.getY()] = 1;
        }
    }

}
