package battleship;

public abstract class ShipsAbstract {
    /**
     * Field name contains name of ship and size contains size of ship.
     */
    protected int size;
    protected String name;

    public abstract int getSize();
    public abstract String getName();
}
