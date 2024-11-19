package tn.esprit.gestionEmployee.interfaces;

public interface IGestion<T> {
    void ajouterEmploye(T t);
    boolean rechercherEmploye(String nom);
    boolean rechercherEmploye(T t);
    void supprimerEmploye(T t);
    void displayEmploye();
    void trierEmployeParId(); // Comparable sorting
    void trierEmployeParNomDepartementEtGrade(); // Comparator sorting
}