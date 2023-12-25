// package FamilyTree.src.presenter;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import FamilyTree.src.model.Person;
// import FamilyTree.src.view.FamilyTreeView;

// public class FamilyTreePresenter {
//     private List<Person> people;
//     private FamilyTreeView view;

//     public FamilyTreePresenter(FamilyTreeView view) {
//         this.view = view;
//         people = new ArrayList<>();
//     }

//     public void addPerson(String name, LocalDate birthDate) {
//         Person person = new Person(name, birthDate);
//         people.add(person);
//     }

//     public void addChild(String parentName, String childName) {
//         Person parent = findPerson(parentName);
//         Person child = findPerson(childName);
//         if (parent != null && child != null) {
//             parent.addChild(child);
//         }
//     }

//     public void displayTree() {
//         view.displayTree();
//     }

//     public void displayChildrenSortedByBirthDate(String personName) {
//         Person person = findPerson(personName);
//         if (person != null) {
//             List<Person> sortedChildren = person.getSortedChildrenByBirthDate();
//             view.displayChildrenSortedByBirthDate(personName, sortedChildren);
//         }
//     }

//     private Person findPerson(String name) {
//         for (Person person : people) {
//             if (person.getName().equals(name)) {
//                 return person;
//             }
//         }
//         return null;
//     }
// }

package FamilyTree.src.presenter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import FamilyTree.src.model.FamilyTree;
import FamilyTree.src.model.Person;
import FamilyTree.src.util.FamilyTreeFileManager;
import FamilyTree.src.view.FamilyTreeView;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTree familyTree;
    private FamilyTreeFileManager fileManager;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        familyTree = new FamilyTree();
        fileManager = new FamilyTreeFileManager();
    }

    public void addPerson(String name, LocalDate birthDate) {
        Person person = new Person(name, birthDate);
        familyTree.addPerson(person);
    }

    public List<Person> getSortedPeople() {
        List<Person> people = familyTree.getPeople();
        Collections.sort(people, new FamilyTree.FamilyTreeComparator());
        return people;
    }

    public void displayFamilyTree() {
        view.displayFamilyTree(getSortedPeople());
    }

    public void saveFamilyTree(String fileName) {
        fileManager.saveFamilyTree(familyTree, fileName);
    }

    public void loadFamilyTree(String fileName) {
        familyTree = fileManager.loadFamilyTree(fileName);
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }
}