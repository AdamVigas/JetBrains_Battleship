package battleship;

public class Cruiser extends ShipsAbstract{
    private String name  = "Cruiser";
    private int size = 3;

    public Cruiser() {
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
