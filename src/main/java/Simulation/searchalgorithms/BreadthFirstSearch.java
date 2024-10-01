package Simulation.searchalgorithms;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.Map;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements SearchAlgorithm{

    @Override
    public Coordinate2D findClosest(Coordinate2D start, Class<? extends Entity> entityType, Map map) {
        Queue<Coordinate2D> queue = new LinkedList<Coordinate2D>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Coordinate2D current = queue.remove();
            int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            for(int[] direction : directions) {
                int x = current.getX() + direction[0];
                int y = current.getY() + direction[1];
                if(x < 0 || x >= map.getWidth() || y < 0 || y >= map.getHeight()) {
                    continue;
                }
                Coordinate2D newCoordinate = new Coordinate2D(x, y);
                Entity entity = map.getEntity(newCoordinate);
                if(entity != null && entity.getClass() == entityType) {
                    return newCoordinate;
                }
                queue.add(newCoordinate);
            }
        }
        return new Coordinate2D(-1, -1);
    }
}
