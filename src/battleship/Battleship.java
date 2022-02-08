package battleship;

public class Battleship extends ShipsAbstract{
    private String name  = "Battleship";
    private int size = 4;

    public Battleship() {
        super.setName(this.name);
        super.setSize(this.size);
    }
}
