package tn.esprit.gestionEmployee.main;

import tn.esprit.gestionEmployee.entites.Employe;
import tn.esprit.gestionEmployee.entites.SocieteArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee by Name");
            System.out.println("4. Search Employee by Object");
            System.out.println("5. Remove Employee");
            System.out.println("6. Sort Employees by ID");
            System.out.println("7. Sort Employees by Department and Grade");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Employee Name: ");
                    String nom = scanner.nextLine();

                    System.out.print("Enter Employee First Name: ");
                    String prenom = scanner.nextLine();

                    System.out.print("Enter Employee Department Name: ");
                    String nomDepartement = scanner.nextLine();

                    System.out.print("Enter Employee Grade: ");
                    int grade = scanner.nextInt();

                    Employe employe = new Employe(id, nom, prenom, nomDepartement, grade);
                    societe.ajouterEmploye(employe);
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    // Display Employees
                    System.out.println("\n--- List of Employees ---");
                    societe.displayEmploye();
                    break;

                case 3:
                    // Search Employee by Name
                    System.out.print("Enter Employee Name to Search: ");
                    String searchName = scanner.nextLine();
                    boolean foundByName = societe.rechercherEmploye(searchName);
                    System.out.println(foundByName ? "Employee found!" : "Employee not found.");
                    break;

                case 4:
                    // Search Employee by Object
                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String searchNom = scanner.nextLine();

                    Employe searchEmploye = new Employe(searchId, searchNom, "", "", 0);
                    boolean foundByObject = societe.rechercherEmploye(searchEmploye);
                    System.out.println(foundByObject ? "Employee found!" : "Employee not found.");
                    break;

                case 5:
                    // Remove Employee
                    System.out.print("Enter Employee ID: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String removeNom = scanner.nextLine();

                    Employe removeEmploye = new Employe(removeId, removeNom, "", "", 0);
                    societe.supprimerEmploye(removeEmploye);
                    System.out.println("Employee removed if existed.");
                    break;

                case 6:
                    // Sort Employees by ID
                    societe.trierEmployeParId();
                    System.out.println("Employees sorted by ID.");
                    break;

                case 7:
                    // Sort Employees by Department and Grade
                    societe.trierEmployeParNomDepartementEtGrade();
                    System.out.println("Employees sorted by Department and Grade.");
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
