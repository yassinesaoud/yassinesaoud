package tn.esprit.gestionEmployee.main;

import tn.esprit.gestionEmployee.entites.AffectationHashMap;
import tn.esprit.gestionEmployee.entites.Departement;
import tn.esprit.gestionEmployee.entites.Employe;

import java.util.Map;
import java.util.TreeMap;

public class MainAffectation {
    public static void main(String[] args) {
        AffectationHashMap gestionAffectation = new AffectationHashMap();

        // Create Employees
        Employe emp1 = new Employe(1, "John", "Doe", "IT", 3);
        Employe emp2 = new Employe(2, "Jane", "Smith", "HR", 2);
        Employe emp3 = new Employe(3, "Alice", "Brown", "Marketing", 1);

        // Create Departments
        Departement dep1 = new Departement(101, "IT", 50);
        Departement dep2 = new Departement(102, "HR", 20);
        Departement dep3 = new Departement(103, "Marketing", 30);

        // Assign Employees to Departments
        gestionAffectation.ajouterEmployeDepartement(emp1, dep1);
        gestionAffectation.ajouterEmployeDepartement(emp2, dep2);
        gestionAffectation.ajouterEmployeDepartement(emp3, dep3);

        // Display Employees and Departments
        System.out.println("\n--- Employees and Their Departments ---");
        gestionAffectation.afficherEmployesEtDepartements();

        // Try adding an employee to a different department
        gestionAffectation.ajouterEmployeDepartement(emp1, dep2);

        // Display updated assignments
        System.out.println("\n--- Updated Employees and Their Departments ---");
        gestionAffectation.afficherEmployesEtDepartements();

        // Remove an Employee
        gestionAffectation.supprimerEmploye(emp2);

        // Remove an Employee from a Specific Department
        gestionAffectation.supprimerEmployeEtDepartement(emp3, dep3);

        // Display Employees
        System.out.println("\n--- List of Employees ---");
        gestionAffectation.afficherEmployes();

        // Display Departments
        System.out.println("\n--- List of Departments ---");
        gestionAffectation.afficherDepartements();

        // Search for an Employee
        System.out.println("\nSearch for Employee emp1: " + gestionAffectation.rechercherEmploye(emp1));

        // Search for a Department
        System.out.println("Search for Department dep2: " + gestionAffectation.rechercherDepartement(dep2));

        // Sort Employees by ID
        System.out.println("\n--- Sorted Employees and Their Departments ---");
        TreeMap<Employe, Departement> sortedMap = gestionAffectation.trierMap();
        for (Map.Entry<Employe, Departement> entry : sortedMap.entrySet()) {
            System.out.println("Employee: " + entry.getKey() + " -> Department: " + entry.getValue());
        }
    }
}
