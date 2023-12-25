// package FamilyTree;

// import java.time.LocalDate;
// import FamilyTree.src.view.FamilyTreeView;
// import FamilyTree.src.view.FamilyTreeViewConsole;
// import FamilyTree.src.presenter.FamilyTreePresenter;

// public class Main {
//     public static void main(String[] args) {
//         FamilyTreeView view = new FamilyTreeViewConsole();
//         FamilyTreePresenter presenter = new FamilyTreePresenter(view);

//         presenter.addPerson("John", LocalDate.of(1980, 5, 15));
//         presenter.addPerson("Mary", LocalDate.of(1982, 8, 21));
//         presenter.addPerson("Tom", LocalDate.of(1990, 3, 10));
//         presenter.addPerson("Alice", LocalDate.of(1995, 11, 7));

//         presenter.addChild("John", "Mary");
//         presenter.addChild("John", "Tom");
//         presenter.addChild("Mary", "Alice");

//         presenter.displayTree();
//         presenter.displayChildrenSortedByBirthDate("John");
//     }
// }

package FamilyTree;

import FamilyTree.src.model.Person;
import FamilyTree.src.model.FamilyTree;
import FamilyTree.src.presenter.FamilyTreePresenter;
import FamilyTree.src.util.FamilyTreeFileManager;
import FamilyTree.src.view.FamilyTreeViewConsole;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTreeViewConsole view = new FamilyTreeViewConsole();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);

        presenter.addPerson("John Smith", LocalDate.of(1980, 1, 1));
        presenter.addPerson("Jane Smith", LocalDate.of(1982, 3, 15));
        presenter.addPerson("David Johnson", LocalDate.of(1955, 7, 10));
        presenter.addPerson("Emily Johnson", LocalDate.of(1960, 9, 20));

        presenter.displayFamilyTree();

        FamilyTree familyTree = presenter.getFamilyTree();
        FamilyTreeFileManager fileManager = new FamilyTreeFileManager();
        fileManager.saveFamilyTree(familyTree, "familytree.dat");

        FamilyTree loadedFamilyTree = fileManager.loadFamilyTree("familytree.dat");
        FamilyTreePresenter loadedPresenter = new FamilyTreePresenter(view);
        loadedPresenter.setFamilyTree(loadedFamilyTree);

        loadedPresenter.displayFamilyTree();
    }
}