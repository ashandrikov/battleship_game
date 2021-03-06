package project.utils;

public class Constants {
    public static final String SHOOSEGAMEMODE = "Please, choose game mode:\n1: player vs player\n2: player vs computer";
    public static final String PL1 = "Player 1, please, input your name:";
    public static final String PL2 = "Player 2, please, input your name:";

    public static final String PLACED = "Ship is placed!";
    public static final String CHOOSESHIPPLACEMENTMODE = ", please, choose ship placement mode:\n1: manual\n2: automatic";
    public static final String NEXTMOVE = "Press ENTER to finish your move";
    public static final String DONE = "\nAll ships are placed!";

    public static final String INPUTSHIPERROR = "Input should be like this: [A7 h] or [B2 v]. Try again!";
    public static final String OUTOFBOARD = "Impossible to place ship here because it is out of board!";
    public static final String SHIPSCROSS = "Impossible to place ship here because ship crosses with another one!";

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String MISS = GREEN + "0" + RESET;
    public static final String HIT = RED + "X" + RESET;
    public static final String WAVE = CYAN + "~" + RESET;

    public static final String MAKESHOT = ", make your shot in format: [A6] or [b1]";
    public static final String INPUTSHOTERROR = "Input should be like this: [A7] or [b2]. Try again!";
    public static final String CHECKED = "Cell is checked. Make another shot!";
    public static final String KILLALL = ", you destroyed all enemy ships. Congratulations!";
    public static final String NEXTMOVE2 = "Press ENTER to finish your move";
    public static final String COMPUTERMOVE = "Computer is thinking...";

    public static final String TIE = "Game over. It's a TIE!";
    public static final String GAMEOVER = "Game over. The winner is: ";
}
