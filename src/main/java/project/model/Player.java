package project.model;

import project.boards.MyBoard;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private MyBoard myBoard;
    private MyBoard myShots;
    private boolean isComputer;
    private final List<Ship> myShips = new ArrayList<>();

    public Player(MyBoard myBoard, MyBoard enemyBoard) {
        this.myBoard = myBoard;
        this.myShots = enemyBoard;
        myBoard.setBasicGrids();
        myShots.setBasicGrids();
    }

    public long countShips() {
        return getMyShips().stream().filter(Ship::isAlive).count();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> getMyShips() {
        return myShips;
    }

    public MyBoard getMyBoard() {
        return myBoard;
    }

    public MyBoard getMyShots() {
        return myShots;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

}
