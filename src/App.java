package battleship;

import java.util.Scanner;

public class App {

    //Scanner for inputs
    final static Scanner scanner = new Scanner(System.in);

    //field that will be instantiated
    private Battlefield battlefield;

    public void placeShips() {
        battlefield = new Battlefield();
        for (ShipsAbstract battleship: battlefield.ships) {
            scan(battlefield,battleship);
        }
        start();
    }

    public void start() {
        System.out.println("\nThe game starts!\n");
        battlefield.printField();
        System.out.println("\nTake a shot!\n");
        int [] input;

        while(true) {
            input = scanShot();
            if (input[0] < 11 && input[0] > 0  && input[1] < 11 && input[1] > 0) {
                if(battlefield.getField()[input[0]][input[1]] == 'O') {
                    battlefield.getField()[input[0]][input[1]] = 'X';
                    System.out.println("\nYou hit a ship!\n");
                    battlefield.printField();
                }else {
                    battlefield.getField()[input[0]][input[1]] = 'M';
                    System.out.println("\nYou missed!\n\n");
                    battlefield.printField();
                }
                break;
            }else {
                System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
            }
        }
    }

    /**
     * Scanning coordinates,testing and setting all ships
     */
    public void scan(Battlefield battlefield, ShipsAbstract battleship) {
        System.out.println("\nEnter the coordinates of the "+ battleship.getName() + " ("+battleship.getSize()+" cells):");
        int [] input;
        while(true) {
            input = scan();
            if(battlefield.checkPlace(input,battleship.getSize(),battleship.getName())) {
                break;
            }
        }
        battlefield.setShip(input);
        battlefield.printField();
    }

    /**
     * @return Array of inputs
     */
    public int[] scan() {
        int [] arr = new int[4];
        String first = scanner.next();
        arr[0] = first.charAt(0) - 64;
        arr[1] = Integer.parseInt(first.substring(1,first.length()));
        first = scanner.next();
        arr[2] = first.charAt(0) - 64;
        arr[3] = Integer.parseInt(first.substring(1,first.length()));
        return arr;
    }


    /**
     * Scan shot
     */
    public int[] scanShot() {
        int [] arr = new int[2];
        String first = scanner.next();
        arr[0] = first.charAt(0) - 64;
        arr[1] = Integer.parseInt(first.substring(1,first.length()));
        return arr;
    }
}
