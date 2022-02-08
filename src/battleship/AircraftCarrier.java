package battleship;

public class AircraftCarrier extends ShipsAbstract{

    private String name  = "Aircraft Carrier";
    private int size = 5;


    public AircraftCarrier() {
        super.setName(this.name);
        super.setSize(this.size);
        super.setCoord(new int[size*2]);
    }
}
