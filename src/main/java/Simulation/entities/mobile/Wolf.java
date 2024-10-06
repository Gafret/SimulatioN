package Simulation.entities.mobile;

import Simulation.searchalgorithms.SearchAlgorithm;

public class Wolf extends Carnivore{
    public Wolf(int health, int movementSpeed, int attackDamage, int attackRadius, SearchAlgorithm searchAlgorithm) {
        super(health, movementSpeed, searchAlgorithm, attackDamage, attackRadius);
    }
}
