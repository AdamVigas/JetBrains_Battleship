package battleship;

public class AircraftCarrier extends ShipsAbstract{

    private String name  = "Aircraft Carrier";
    private int size = 5;
    private int[] coord = new int[size*2];

    public AircraftCarrier() {
        super.size = this.size;
    }

    @Override
    public void Coordinates(int [] arr) {
        int counter = 0;
        if(arr[0] == arr[2]) {
            if(arr[1] < arr[3]) {
                int num = arr[1];
                while(num <= arr[3]){

                    coord[counter++] = arr[0];
                    coord[counter++] = num;
                    num++;
                }
            }else {
                int num = arr[1];
                while (num >= arr[3]) {
                    coord[counter++] = arr[0];
                    coord[counter++] = num;
                    num--;
                }
            }
        }else {
            if(arr[0] < arr[2]) {
                int num = arr[0];
                while(num <= arr[2]){
                    coord[counter++] = num;
                    coord[counter++] = arr[1];
                    num++;
                }
            }else {
                int num = arr[0];
                while (num >= arr[2]) {
                    coord[counter++] = num;
                    coord[counter++] = arr[1];
                    num--;
                }
            }
        }
    }

    @Override
    public int checkWhatHappend(int [] arr) {
        for (int i = 0; i < coord.length; i += 2) {
            //hit target
            if(coord[i] == arr[0] && coord[i+1] == arr[1]) {
                size--;
                if(size == 0) {
                    return 3;
                }else return 2;
            }
        }
        return 1;
    }

    public void decrease() {
        this.size--;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int[] getCoord() {
        return coord;
    }

    @Override
    public void setCoord(int[] coord) {
        this.coord = coord;
    }

    @Override
    public int getSize() {
        return size;
    }
}
