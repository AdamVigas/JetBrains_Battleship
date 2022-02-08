package battleship;

public class Submarine extends ShipsAbstract{
    private String name  = "Submarine";
    private int size = 3;

    public Submarine() {
        super.setName(this.name);
        super.setSize(this.size);
    }
}
