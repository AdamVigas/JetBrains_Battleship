package battleship;

public class Submarine extends ShipsAbstract{
    private String name  = "Submarine";
    private int size = 3;

    public Submarine() {
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
