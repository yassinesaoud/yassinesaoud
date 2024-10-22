package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {
        Dolphin dolphin1 = new Dolphin("Aquatic", "Flipper", 5, true, "Ocean", 20.5f);
        Penguin penguin1 = new Penguin("Aquatic", "Pingu", 3, false, "Antarctica", 15.0f);
        Dolphin dolphin2 = new Dolphin("Aquatic", "Splash", 4, true, "Sea", 18.0f);

        Zoo zoo = new Zoo("AquaZoo", "Monastir");
        zoo.addAquaticAnimal(dolphin1);
        zoo.addAquaticAnimal(penguin1);
        zoo.addAquaticAnimal(dolphin2);

        // Display aquatic animals swimming
        zoo.displayAquaticAnimalsSwimming();

        // Find max penguin swimming depth
        System.out.println("Max penguin swimming depth: " + zoo.maxPenguinSwimmingDepth());

        // Display number of dolphins and penguins
        zoo.displayNumberOfAquaticsByType();
    }
}
