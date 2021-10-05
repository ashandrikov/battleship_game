package project.service.inputs;

import java.util.Scanner;

import static project.utils.Constants.NEXTMOVE;
import static project.utils.Constants.NEXTMOVE2;

public abstract class InputReader {
    protected Scanner scanner;

    public String readLine() {
        return scanner.nextLine();
    }

    public void printBigSpace() {
        System.out.println(NEXTMOVE);
        readLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public void printBigSpaceInShooter(boolean hasSence) {
        if (hasSence) {
            System.out.println(NEXTMOVE2);
            readLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
