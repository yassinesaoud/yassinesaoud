package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.enums.Food;
import tn.esprit.gestionzoo.interfaces.Omnivore;

public abstract class Terrestrial extends Animal implements Omnivore<Food> {
    private int nbrLegs;

    public Terrestrial() {}

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        this.nbrLegs = nbrLegs;
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
        return super.toString() + ", nbrLegs=" + nbrLegs;
    }
}