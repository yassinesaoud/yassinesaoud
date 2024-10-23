package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.*;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("AquaZoo", "Monastir");

        try {
            // Creating some animals
            Animal lion = new Animal("Feline", "Simba", -1, true);
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

        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
