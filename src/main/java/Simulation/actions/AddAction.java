package Simulation.actions;

import Simulation.entities.base.Entity;
import Simulation.map.Coordinate2D;
import Simulation.map.SimulationMap;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class AddAction implements Action {
    private final Class<? extends Entity> addTarget;
    private final int numberToAdd;
    private final Class<?>[] parameterTypes;
    private final Object[] arguments;

    public AddAction(Class<? extends Entity> addTarget, int numberToAdd, Class<?>[] parameterTypes, Object[] arguments) {
        this.addTarget = addTarget;
        this.numberToAdd = numberToAdd;
        this.parameterTypes = parameterTypes;
        this.arguments = arguments;
    }

    private Entity createInstance()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends Entity> constructor = addTarget.getDeclaredConstructor(parameterTypes);
        return constructor.newInstance(arguments);
    }

    @Override
    public void execute(SimulationMap map) {
        int i=0;
        while(i != numberToAdd) {
            Coordinate2D emptyCell = map.getEmptyCell();
            try {
                map.addEntity(createInstance(), emptyCell);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                System.out.println("Couldn't add entity, issue with reflection " + e.getMessage());
            }
            i++;
        }
    }
}
