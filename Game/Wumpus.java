package Game;

/**
 * Created by swapn on 9/23/2016.
 */
public class Wumpus {
    public enum WumpusSize{
        big, small, medium
    }
    int health;
    WumpusSize size;
    Coordinate coordinate;

    public Wumpus(int health, WumpusSize size, Coordinate coordinate){
        this.health = health;
        this.size = size;
        this.coordinate = coordinate;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public WumpusSize getSize() {
        return size;
    }

    public void setSize(WumpusSize size) {
        this.size = size;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
