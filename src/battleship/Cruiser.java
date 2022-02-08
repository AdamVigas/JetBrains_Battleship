package battleship;

public class Cruiser extends ShipsAbstract{
    private String name  = "Cruiser";
    private int size = 3;

    public Cruiser() {
        super.setName(this.name);
        super.setSize(this.size);
        super.setCoord(new int[size*2]);
    }
}
