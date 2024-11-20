package tn.esprit.gestionEmployee.entites;

import tn.esprit.gestionEmployee.interfaces.IDepartement;

import java.util.HashSet;
import java.util.TreeSet;

public class DepartementHashSet implements IDepartement<Departement> {
    private HashSet<Departement> departements = new HashSet<>();

    @Override
    public void ajouterDepartement(Departement t) {
        if (departements.add(t)) {
            System.out.println("Department added successfully!");
        } else {
            System.out.println("Department already exists!");
        }
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        for (Departement d : departements) {
            if (d.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement t) {
        return departements.contains(t);
    }

    @Override
    public void supprimerDepartement(Departement t) {
        if (departements.remove(t)) {
            System.out.println("Department removed successfully!");
        } else {
            System.out.println("Department not found!");
        }
    }

    @Override
    public void displayDepartement() {
        if (departements.isEmpty()) {
            System.out.println("No departments to display.");
        } else {
            for (Departement d : departements) {
                System.out.println(d);
            }
        }
    }

    @Override
    public TreeSet<Departement> trierDepartementById() {
        TreeSet<Departement> sortedSet = new TreeSet<>((d1, d2) -> Integer.compare(d1.getId(), d2.getId()));
        sortedSet.addAll(departements);
        return sortedSet;
    }
}
