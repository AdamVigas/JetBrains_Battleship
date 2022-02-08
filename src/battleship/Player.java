package battleship;


import java.util.Arrays;
import java.util.Scanner;

public class Player {

    //Scanner for inputs
    final static Scanner scanner = new Scanner(System.in);


    //field that will be instantiated
    private Battlefield battlefield;

    public void placeShips() {
        battlefield = new Battlefield();
        addShips(battlefield);
    }

    public int bombChecker(int [] arrIn) {
        for (ShipsAbstract ship: battlefield.ships) {
            int r = ship.checkWhatHappend(arrIn);
            if(r == 3) {
                battlefield.ships.remove(ship);
                return r;
            }else if(r == 2 ) {
                return r;
            }
        }
        return 1;
    }


    public Battlefield getBattlefield() {
        return battlefield;
    }

    /**
     * Scanning coordinates,testing and setting all ships
     */
    public void addShips(Battlefield battlefield) {
    for (ShipsAbstract ship: battlefield.ships) {
        System.out.println("\nEnter the coordinates of the "+ ship.getName() + " (" +ship.getSize()+" cells):");
        int [] input;
            while(true) {
                input = scan();

                if(battlefield.checkPlace(input,ship.getSize(),ship.getName())) {
                    break;
                }
            }
        ship.Coordinates(input);
        battlefield.setShip(input);
        battlefield.printField(battlefield.getField());
        }
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
