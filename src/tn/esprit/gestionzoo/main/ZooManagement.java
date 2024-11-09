package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.*;
import tn.esprit.gestionzoo.interfaces.*;
import tn.esprit.gestionzoo.enums.Food;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("AquaZoo", "Monastir");

        try {
            // Creating some animals
            Animal lion = new Animal("Feline", "Simba", 7, true);
            Animal tiger = new Animal("Feline", "Shere Khan", 6, true);
            Animal elephant = new Animal("Mammal", "Dumbo", 10, true);
            Animal bear = new Animal("Mammal", "Baloo", 5, true);

            // Adding animals and handling exceptions
            zoo.addAnimal(lion);
            System.out.println("Number of animals in the zoo: " + zoo.getNbrAnimals());

            zoo.addAnimal(tiger);
            System.out.println("Number of animals in the zoo: " + zoo.getNbrAnimals());

            zoo.addAnimal(elephant);
            System.out.println("Number of animals in the zoo: " + zoo.getNbrAnimals());

            // This one should trigger the exception
            zoo.addAnimal(bear);
            System.out.println("Number of animals in the zoo: " + zoo.getNbrAnimals());
            //interfaces
            lion.eatMeat(Food.MEAT);
            System.out.println("Lion eats meat");
            tiger.eatMeat(Food.MEAT);
            System.out.println("Tiger eats meat");
            elephant.eatPlant(Food.PLANT);
            System.out.println("Elephant eats plant");
            bear.eatBoth(Food.BOTH);
            System.out.println("Bear eats both");




        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }

}
