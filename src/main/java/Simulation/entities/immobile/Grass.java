package Simulation.entities.immobile;

import Simulation.entities.base.Entity;

public class Grass extends Entity implements HerbivoreFood {
    private static final int healthRestore = 3;

    public Grass() {}

    @Override
    public int getHealthRestore() {
        return healthRestore;
    }
}
