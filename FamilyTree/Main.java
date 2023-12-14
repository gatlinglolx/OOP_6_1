package FamilyTree;

import java.time.LocalDate;
import FamilyTree.src.view.FamilyTreeView;
import FamilyTree.src.view.FamilyTreeViewConsole;
import FamilyTree.src.presenter.FamilyTreePresenter;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView view = new FamilyTreeViewConsole();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);

        presenter.addPerson("John", LocalDate.of(1980, 5, 15));
        presenter.addPerson("Mary", LocalDate.of(1982, 8, 21));
        presenter.addPerson("Tom", LocalDate.of(1990, 3, 10));
        presenter.addPerson("Alice", LocalDate.of(1995, 11, 7));

        presenter.addChild("John", "Mary");
        presenter.addChild("John", "Tom");
        presenter.addChild("Mary", "Alice");

        presenter.displayTree();
        presenter.displayChildrenSortedByBirthDate("John");
    }
}