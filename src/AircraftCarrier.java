package battleship;

public class AircraftCarrier extends ShipsAbstract{

    private String name  = "Aircraft Carrier";
    private int size = 5;

    public AircraftCarrier() {
        super.size = this.size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}
