package battleship;

public class Destroyer extends ShipsAbstract{
    private String name  = "Destroyer";
    private int size = 2;

    public Destroyer() {
        super.setName(this.name);
        super.setSize(this.size);
        super.setCoord(new int[size*2]);
    }
}
