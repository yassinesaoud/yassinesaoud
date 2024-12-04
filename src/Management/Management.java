package Management;

import Entity.Etudiant;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public interface Management {
    void displayStudents(List<Etudiant> students, Consumer<Etudiant> con);

    void displayStudentsByFilter(List<Etudiant> students, Predicate<Etudiant> pre, Consumer<Etudiant> con);

    String returnStudentsNames(List<Etudiant> students, Function<Etudiant, String> fun);

    Etudiant createStudent(Supplier<Etudiant> sup);

    List<Etudiant> sortStudentsById(List<Etudiant> students, Comparator<Etudiant> com);

    Stream<Etudiant> convertToStream(List<Etudiant> students);
}
