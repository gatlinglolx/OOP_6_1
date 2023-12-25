// package FamilyTree.src.view;

// import java.util.List;
// import FamilyTree.src.model.Person;

// public class FamilyTreeViewConsole implements FamilyTreeView {
//     @Override
//     public void displayTree() {
//         System.out.println("Family Tree: ");
//     }

//     @Override
//     public void displayChildrenSortedByBirthDate(String personName, List<Person> children) {
//     System.out.println("Children of " + personName + " sorted by birth date:");
//         for (Person child : children) {
//             System.out.println(child.getName() + " - " + child.getBirthDate());
//         }
//     }
// }

package FamilyTree.src.view;

import java.util.List;

import FamilyTree.src.model.Person;

public class FamilyTreeViewConsole implements FamilyTreeView {
    @Override
    public void displayFamilyTree(List<Person> people) {
        System.out.println("Displaying family tree:");
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }
    }
}