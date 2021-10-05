package project.service;

import lombok.SneakyThrows;
import project.model.Player;
import project.service.inputs.InputReader;

import static project.utils.Constants.*;


public class GameModeAndNameSetter {
    private final InputReader inputReader;

    private int gameMode;

    public GameModeAndNameSetter(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @SneakyThrows
    public void setNames(Player player1, Player player2) {

        defineGameMode();

        System.out.println(PL1);
        String player1Name = inputReader.readLine();
        player1.setName(player1Name);
        System.out.println("Hello, " + player1Name + "!");

        if (gameMode == 1) {
            System.out.println(PL2);
            String player2Name = inputReader.readLine();
            player2.setName(player2Name);
            System.out.println("Hello, " + player2Name + "!");
        } else if (gameMode == 2) {
            player2.setName("Computer");
            player2.setComputer(true);
        }
    }

    private void defineGameMode() {
        while (true) {
            System.out.println(SHOOSEGAMEMODE);
            String gameModeInput = inputReader.readLine();
            if (gameModeInput.matches("[1]|[2]")) {
                gameMode = Integer.parseInt(gameModeInput);
                break;
            }
        }
    }

}
