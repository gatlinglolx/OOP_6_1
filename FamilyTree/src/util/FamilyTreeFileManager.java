package FamilyTree.src.util;

import FamilyTree.src.model.FamilyTree;
import FamilyTree.src.model.Person;

import java.io.*;
import java.util.List;

public class FamilyTreeFileManager {
    public void saveFamilyTree(FamilyTree familyTree, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(familyTree);

            System.out.println("Family tree saved successfully.");

        } catch (IOException e) {
            System.out.println("Failed to save the family tree: " + e.getMessage());
        }
    }

    public FamilyTree loadFamilyTree(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();

            System.out.println("Family tree loaded successfully.");
            return familyTree;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load the family tree: " + e.getMessage());
        }

        return null;
    }
}