package tn.esprit.gestionEmployee.main;

import tn.esprit.gestionEmployee.entites.Departement;
import tn.esprit.gestionEmployee.entites.DepartementHashSet;

import java.util.Scanner;

public class MainDepartment {
    public static void main(String[] args) {
        DepartementHashSet gestionDepartements = new DepartementHashSet();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Department Management System ---");
            System.out.println("1. Add Department");
            System.out.println("2. Display Departments");
            System.out.println("3. Search Department by Name");
            System.out.println("4. Search Department by Object");
            System.out.println("5. Remove Department");
            System.out.println("6. Display Departments Sorted by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Department
                    System.out.print("Enter Department ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Department Name: ");
                    String nom = scanner.nextLine();

                    System.out.print("Enter Number of Employees: ");
                    int nombreEmployes = scanner.nextInt();

                    Departement newDept = new Departement(id, nom, nombreEmployes);
                    gestionDepartements.ajouterDepartement(newDept);
                    break;

                case 2:
                    // Display Departments
                    System.out.println("\n--- List of Departments ---");
                    gestionDepartements.displayDepartement();
                    break;

                case 3:
                    // Search Department by Name
                    System.out.print("Enter Department Name to Search: ");
                    String searchNom = scanner.nextLine();
                    boolean foundByName = gestionDepartements.rechercherDepartement(searchNom);
                    System.out.println(foundByName ? "Department found!" : "Department not found.");
                    break;

                case 4:
                    // Search Department by Object
                    System.out.print("Enter Department ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Department Name: ");
                    String searchName = scanner.nextLine();

                    Departement searchDept = new Departement(searchId, searchName, 0);
                    boolean foundByObject = gestionDepartements.rechercherDepartement(searchDept);
                    System.out.println(foundByObject ? "Department found!" : "Department not found.");
                    break;

                case 5:
                    // Remove Department
                    System.out.print("Enter Department ID: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Department Name: ");
                    String removeName = scanner.nextLine();

                    Departement removeDept = new Departement(removeId, removeName, 0);
                    gestionDepartements.supprimerDepartement(removeDept);
                    break;

                case 6:
                    // Display Sorted Departments
                    System.out.println("\n--- Departments Sorted by ID ---");
                    for (Departement d : gestionDepartements.trierDepartementById()) {
                        System.out.println(d);
                    }
                    break;

                case 0:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
