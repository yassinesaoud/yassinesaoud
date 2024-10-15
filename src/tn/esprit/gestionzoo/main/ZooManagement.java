package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {
        Dolphin dolphin = new Dolphin("Aquatic", "Flipper", 5, true, "Ocean", 20.5f);
        Penguin penguin = new Penguin("Aquatic", "Pingu", 3, false, "Antarctica", 15.0f);
        Terrestrial tiger = new Terrestrial("Feline", "Tiger", 8, true, 4);

        System.out.println(dolphin);
        System.out.println(penguin);
        System.out.println(tiger);

        dolphin.swim();
        penguin.swim();
    }
}
