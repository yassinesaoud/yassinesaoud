package tn.esprit.gestionEmployee.entites;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AffectationHashMap {
    private final HashMap<Employe, Departement> affectations = new HashMap<>();

    // Instruction 2: Add Employee to a Department
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d);
        System.out.println("Employee assigned to department successfully!");
    }

    // Instruction 3: Display All Employees and Their Departments
    public void afficherEmployesEtDepartements() {
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println("Employee: " + entry.getKey() + " -> Department: " + entry.getValue());
        }
    }

    // Instruction 4: Remove an Employee
    public void supprimerEmploye(Employe e) {
        if (affectations.remove(e) != null) {
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Instruction 5: Remove an Employee from a Specific Department
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
            System.out.println("Employee removed from the specified department!");
        } else {
            System.out.println("No matching employee in the specified department!");
        }
    }

    // Instruction 6: Display Employees
    public void afficherEmployes() {
        System.out.println("List of Employees:");
        for (Employe e : affectations.keySet()) {
            System.out.println(e);
        }
    }

    // Instruction 7: Display Departments
    public void afficherDepartements() {
        System.out.println("List of Departments:");
        for (Departement d : affectations.values()) {
            System.out.println(d);
        }
    }

    // Instruction 8: Search for an Employee
    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    // Instruction 9: Search for a Department
    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    // Instruction 10: Sort Map by Employee ID
    public TreeMap<Employe, Departement> trierMap() {
        return new TreeMap<>((e1, e2) -> Integer.compare(e1.getId(), e2.getId()));
    }
}
