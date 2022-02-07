package battleship;

public class Battleship extends ShipsAbstract{
    private String name  = "Battleship";
    private int size = 4;

    public Battleship() {
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
