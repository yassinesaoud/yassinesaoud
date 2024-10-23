package tn.esprit.gestionzoo.entities;
import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

public class Zoo {

    public static final int NUMBER_OF_CAGES = 25;
    private static final int MAX_AQUATIC_ANIMALS = 10;

    private Animal[] animals;
    private Aquatic[] aquaticAnimals; // Array for aquatic animals
    private String name, city;
    private int nbrAnimals;
    private int nbrAquaticAnimals;  // Counter for aquatic animals

    public Zoo() {
        animals = new Animal[NUMBER_OF_CAGES];
        aquaticAnimals = new Aquatic[MAX_AQUATIC_ANIMALS];
    }

    public Zoo(String name, String city) {
        this();
        this.name = name;
        this.city = city;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals)
            return z1;
        return z2;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank())
            System.out.println("The Zoo name cannot be empty");
        else
            this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public void setNbrAnimals(int nbrAnimals) {
        this.nbrAnimals = nbrAnimals;
    }
    public int getNbrAquaticAnimals() {
        return nbrAquaticAnimals;
    }
    public void setNbrAquaticAnimals(int nbrAquaticAnimals) {
        this.nbrAquaticAnimals = nbrAquaticAnimals;
    }
    public Aquatic[] getAquaticAnimals() {
        return aquaticAnimals;
    }
    public void setAquaticAnimals(Aquatic[] aquaticAnimals) {
        this.aquaticAnimals = aquaticAnimals;
    }

    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals);
    }

    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (nbrAnimals >= NUMBER_OF_CAGES) {
            throw new ZooFullException("The zoo is full. Cannot add more animals.");
        }
        if(animal.getAge()<0){
            throw new InvalidAgeException("the age cannot be negative must be postive or zero");
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
    }


    public boolean removeAnimal(Animal animal) {
        int indexAnimal = searchAnimal(animal);
        if (indexAnimal == -1)
            return false;
        for (int i = indexAnimal; i < nbrAnimals; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals] = null;
        this.nbrAnimals--;
        return true;
    }

    public void displayAnimals() {
        System.out.println("List of animals of " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.getName() == animals[i].getName())
                return i;
        }
        return index;
    }

    public boolean isZooFull() {
        return nbrAnimals == NUMBER_OF_CAGES;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals;
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        if (nbrAquaticAnimals < MAX_AQUATIC_ANIMALS) {
            aquaticAnimals[nbrAquaticAnimals] = aquatic;
            nbrAquaticAnimals++;
        } else {
            System.out.println("The zoo has reached the maximum number of aquatic animals.");
        }
    }
    public void displayAquaticAnimalsSwimming() {
        System.out.println("Aquatic animals swimming:");
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            aquaticAnimals[i].swim();
        }
    }
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0;
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }
    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;

        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            }
        }

        System.out.println("Number of dolphins: " + dolphinCount);
        System.out.println("Number of penguins: " + penguinCount);
    }



    }



