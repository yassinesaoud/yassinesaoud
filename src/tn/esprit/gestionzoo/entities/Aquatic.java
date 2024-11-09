package tn.esprit.gestionzoo.entities;
import tn.esprit.gestionzoo.enums.Food;
import tn.esprit.gestionzoo.interfaces.Carnivore;

import java.util.Objects;


public abstract class Aquatic extends Animal implements Carnivore<Food> {
    private String habitat;

    public Aquatic() {}

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    public void eatMeat(Food meat) {
        if(meat == Food.MEAT){
            System.out.println(getName()+"is eating meat");
        }else{
            System.out.println(getName()+"cannot eat this type of food ");
        }

    }
    public void eatPlant(Food plant) {
        if(plant == Food.PLANT){
            System.out.println(getName()+"is eating plant");
        }else{
            System.out.println(getName()+"cannot eat this type of food ");
        }
    }
    public void eatBoth(Food Both) {
        if(Both == Food.PLANT || Both == Food.MEAT){
            System.out.println(getName()+"is eating both");
            eatMeat(Both);
            eatPlant(Both);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + '\'';
    }

    public abstract void swim();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Aquatic aquatic = (Aquatic) obj;

        return this.getName().equals(aquatic.getName()) &&
                this.getAge() == aquatic.getAge() &&
                this.habitat.equals(aquatic.habitat);
    }
}
