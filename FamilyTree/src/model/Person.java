package FamilyTree.src.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String name;
    private LocalDate birthDate;
    private List<Person> children;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getSortedChildrenByBirthDate() {
        List<Person> sortedChildren = new ArrayList<>(children);
        sortedChildren.sort(Comparator.comparing(Person::getBirthDate));
        return sortedChildren;
    }
}