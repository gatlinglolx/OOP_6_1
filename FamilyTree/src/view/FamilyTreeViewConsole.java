package FamilyTree.src.view;

import java.util.List;
import FamilyTree.src.model.Person;

public class FamilyTreeViewConsole implements FamilyTreeView {
    @Override
    public void displayTree() {
        System.out.println("Family Tree: ");
    }

    @Override
    public void displayChildrenSortedByBirthDate(String personName, List<Person> children) {
    System.out.println("Children of " + personName + " sorted by birth date:");
        for (Person child : children) {
            System.out.println(child.getName() + " - " + child.getBirthDate());
        }
    }
}