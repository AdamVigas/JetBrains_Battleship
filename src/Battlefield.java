package battleship;


import java.util.ArrayList;
import java.util.List;

public class Battlefield {

    /**
     * Creating field of chars with 10x10 size.
     */
     private char [][] field = new char[12][12];
    /**
     * List containing instances of all ships
     */
    List<ShipsAbstract> ships;

    public Battlefield() {
        printField();
        ships = new ArrayList<>();
        ships.add(new AircraftCarrier());
        ships.add(new Battleship());
        ships.add(new Submarine());
        ships.add(new Cruiser());
        ships.add(new Destroyer());
    }

    public char[][] getField() {
        return field;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    /**
     * Print field
     */
    public void printField() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        int letter = 'A';
        for(int i = 1; i <= 10; i++) {
            System.out.print((char) letter++ + " ");
            for (int j = 1; j <= 10; j++) {
                if(field[i][j] != 0) {
                    System.out.print(field[i][j] + " ");
                }else {
                    System.out.print('~' + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Checking collision or nearby ship
     */
    public boolean checkCollision(int [] arr) {
        if(field[arr[0]-1][arr[1]-1] == 0 && field[arr[0]-1][arr[1]] == 0 && field[arr[0]-1][arr[1]+1] == 0){
            if(field[arr[0]][arr[1]-1] == 0 && field[arr[0]][arr[1]] == 0 && field[arr[0]][arr[1]+1] == 0){
                if(field[arr[0]+1][arr[1]-1] == 0 && field[arr[0]+1][arr[1]] == 0 && field[arr[0]+1][arr[1]+1] == 0){
                    return true;
                }
            }
        }
        System.out.println("\nError! You placed it too close to another one. Try again:\n");
        return false;
    }

    /**
     * Error handler
     */
    public boolean checkPlace(int [] arr,int size,String name) {
        if(arr[1]!=arr[3] && arr[0] != arr[2]){
            System.out.println("\nError! Wrong ship location! Try again:\n");
            return false;
        }else if (arr[1] == arr[3]) {
            int result = Math.max(arr[0],arr[2]) - Math.min(arr[0],arr[2]);
            if(result == size-1) {
                return checkCollision(arr);
            }else {
                System.out.println("\nError! Wrong length of the "+ name +"! Try again:\n");
                return false;
            }
        }else if (arr[0] == arr[2]) {
            int result = Math.max(arr[1],arr[3]) - Math.min(arr[1],arr[3]);
            if(result == size-1) {
                return checkCollision(arr);
            }else {
                System.out.println("\nError! Wrong length of the "+ name +"! Try again:\n");
                return false;
            }
        }
        return false;
    }

    /**
     * Setting ship to our field
     */
    public void setShip(int [] arr) {
        if(arr[0] == arr[2]) {
            if(arr[1] < arr[3]) {
                int num = arr[1];
                while(num <= arr[3]){
                    field[arr[0]][num] = 'O';
                    num++;
                }
            }else {
                int num = arr[1];
                while (num >= arr[3]) {
                    field[arr[0]][num] = 'O';
                    num--;
                }
            }
        }else {
            if(arr[0] < arr[2]) {
                int num = arr[0];
                while(num <= arr[2]){
                    field[num][arr[1]] = 'O';
                    num++;
                }
            }else {
                int num = arr[0];
                while (num >= arr[2]) {
                    field[num][arr[1]] = 'O';
                    num--;
                }
            }
        }
    }
}
