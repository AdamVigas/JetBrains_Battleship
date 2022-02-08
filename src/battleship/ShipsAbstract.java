package battleship;

public abstract class ShipsAbstract {
    /**
     * Field name contains name of ship and size contains size of ship.
     */
    protected int size;
    protected String name;
    protected int[] coord;


    public abstract void Coordinates(int [] arr);

    public abstract int getSize();
    public abstract String getName();

    public abstract int checkWhatHappend(int [] arr);

    public abstract int[] getCoord();
    public abstract void setCoord(int[] coord);

}
