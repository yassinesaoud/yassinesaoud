package Main;

import Entity.Etudiant;
import Management.StudentManagement;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        List<Etudiant> students = new ArrayList<>();
        students.add(new Etudiant(1, "Alice", 20));
        students.add(new Etudiant(2, "Bob", 22));
        students.add(new Etudiant(3, "Charlie", 19));

        StudentManagement sm = new StudentManagement();


        System.out.println("Liste des étudiants :");
        sm.displayStudents(students, System.out::println);


        System.out.println("\nÉtudiants ayant plus de 20 ans :");
        sm.displayStudentsByFilter(students, e -> e.getAge() > 20, System.out::println);


        System.out.println("\nNoms des étudiants :");
        String names = sm.returnStudentsNames(students, Etudiant::getNom);
        System.out.println(names);


        Etudiant newStudent = sm.createStudent(() -> new Etudiant(4, "Diana", 21));
        students.add(newStudent);


        System.out.println("\nÉtudiants triés par ID :");
        List<Etudiant> sortedStudents = sm.sortStudentsById(students, Comparator.comparingInt(Etudiant::getId));
        sortedStudents.forEach(System.out::println);


        System.out.println("\nÉtudiants en Stream :");
        sm.convertToStream(students).forEach(System.out::println);
    }
}
