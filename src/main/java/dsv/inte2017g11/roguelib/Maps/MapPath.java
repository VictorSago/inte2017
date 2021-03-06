package dsv.inte2017g11.roguelib.Maps;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A wrapper class for a double ended queue
 * representing a path through through a map
 */
public class MapPath {

    private Deque<Direction> pathQueue = new ArrayDeque<>();

    public boolean isEmpty() {
        return pathQueue.isEmpty();
    }

    public int getPathLength() {
        return pathQueue.size();
    }

    public boolean appendStep(Direction dir) {
        if (dir != null) {
            return pathQueue.offerLast(dir);
        } else {
            return false;
        }
    }

    public Direction getNextStep() {
        return pathQueue.pollFirst();
    }
}
