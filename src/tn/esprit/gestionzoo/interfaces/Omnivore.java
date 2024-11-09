package tn.esprit.gestionzoo.interfaces;

public interface Omnivore <T> extends Carnivore<T>, Herbivore<T>{
    void eatPlantAndMeat(T plant, T meat);

}
