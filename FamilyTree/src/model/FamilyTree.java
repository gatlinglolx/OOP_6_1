package FamilyTree.src.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Person> {
    private List<Person> people;

    public FamilyTree() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    @Override
    public Iterator<Person> iterator() {
        return new FamilyTreeIterator();
    }

    private class FamilyTreeIterator implements Iterator<Person> {
        private int index;

        public FamilyTreeIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < people.size();
        }

        @Override
        public Person next() {
            if (hasNext()) {
                Person person = people.get(index);
                index++;
                return person;
            }
            throw new IndexOutOfBoundsException("No more elements in the family tree.");
        }
    }

    public static class FamilyTreeComparator implements Comparator<Person> {
        @Override
        public int compare(Person person1, Person person2) {
            return person1.getName().compareTo(person2.getName());
        }
    }
}