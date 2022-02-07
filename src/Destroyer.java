package battleship;

public class Destroyer extends ShipsAbstract{
    private String name  = "Destroyer";
    private int size = 2;

    public Destroyer() {
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
