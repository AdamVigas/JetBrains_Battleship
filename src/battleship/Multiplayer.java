package battleship;

import java.io.IOException;
import java.util.Arrays;


public class Multiplayer {

    Player player1;
    Player player2;

    public static void promptEnterKey() {
        System.out.println("\nPress Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Player 1, place your ships on the game field.\n");
        player1 = new Player();
        player1.placeShips();
        promptEnterKey();
        System.out.println("Player 2, place your ships to the game field\n");
        player2 = new Player();
        player2.placeShips();
        int sunk1 = 0;
        int sunk2 = 0;
        promptEnterKey();
        boolean gameChanger = true;
        int[] input;
        while (true) {
            if (gameChanger) {
                player1.getBattlefield().printField(player1.getBattlefield().getHiddenField());
                System.out.println("---------------------");
                player1.getBattlefield().printField(player1.getBattlefield().getField());
                System.out.println("\nPlayer 1, it's your turn:\n");
                input = player2.scanShot();
                if (input[0] < 11 && input[0] > 0 && input[1] < 11 && input[1] > 0) {
                    if (player2.getBattlefield().getField()[input[0]][input[1]] == 'O') {
                        player1.getBattlefield().getHiddenField()[input[0]][input[1]] = 'X';
                        player2.getBattlefield().getField()[input[0]][input[1]] = 'X';


                        int result = player2.bombChecker(input);
                        if(result == 2) {
                            System.out.println("\nYou hit a ship!");
                        }else if (result == 3) {
                            sunk2++;
                            if(sunk2 == 5) {
                                System.out.println("\nYou sank the last ship. You won. Congratulations!");
                                System.exit(0);
                            }else
                            System.out.println("\nYou sank a ship!");
                        }


                    }else {
                        if (player2.getBattlefield().getField()[input[0]][input[1]] == 'X') {
                            System.out.println("\nYou hit a ship!");
                        }else {
                            player1.getBattlefield().getHiddenField()[input[0]][input[1]] = 'M';
                            player2.getBattlefield().getField()[input[0]][input[1]] = 'M';
                            System.out.println("\nYou missed!");
                        }

                    }
                        promptEnterKey();
                        gameChanger = false;
                    } else {
                        System.out.println("\nError! You entered the wrong coordinates! Try again:");
                    }
                } else {
                    player2.getBattlefield().printField(player2.getBattlefield().getHiddenField());
                    System.out.println("---------------------");
                    player2.getBattlefield().printField(player2.getBattlefield().getField());
                    System.out.println("\nPlayer 2, it's your turn:\n");
                    input = player1.scanShot();
                    if (input[0] < 11 && input[0] > 0 && input[1] < 11 && input[1] > 0) {
                        if (player1.getBattlefield().getField()[input[0]][input[1]] == 'O') {
                            player2.getBattlefield().getHiddenField()[input[0]][input[1]] = 'X';
                            player1.getBattlefield().getField()[input[0]][input[1]] = 'X';
                            System.out.println("sme tu");

                            int result = player1.bombChecker(input);
                            if(result == 2) {
                                System.out.println("\nYou hit a ship!");
                            }else if (result == 3) {
                                sunk1++;
                                if(sunk1 == 5) {
                                    System.out.println("\nYou sank the last ship. You won. Congratulations!");
                                    System.exit(0);
                                }else
                                    System.out.println("\nYou sank a ship!");
                            }


                        } else {
                            if (player1.getBattlefield().getField()[input[0]][input[1]] == 'X') {
                                System.out.println("\nYou hit a ship!");
                            }else {
                                player2.getBattlefield().getHiddenField()[input[0]][input[1]] = 'M';
                                player1.getBattlefield().getField()[input[0]][input[1]] = 'M';
                                System.out.println("\nYou missed!");
                            }
                        }
                        promptEnterKey();
                        gameChanger = true;
                    } else {
                        System.out.println("\nError! You entered the wrong coordinates! Try again:");
                        }

            }

        }

    }
}

