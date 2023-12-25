package FamilyTree.src.view;

import java.util.List;
import FamilyTree.src.model.Person;

public interface FamilyTreeView {
    //void displayTree();
    //void displayChildrenSortedByBirthDate(String personName, List<Person> children);
    void displayFamilyTree(List<Person> sortedPeople);
}