import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AnimalTester extends Animal {

    public static void main(String[] args) {


        //Create Cat and Dog objects and add to linkedList
        Cat Kitten = new Cat("Kitten", "Ragdoll", 10);
        Cat Mojo = new Cat("Mojo", "Domestic Shorthair", 6);
        Dog Dog1 = new Dog("Dog1", "Bernese Mountain Dog", 9);
        Dog Dog2 = new Dog("Dog2", "Dalmation", 7);
        System.out.println(Kitten.sound());

        LinkedList<Animal> animalList = new LinkedList<>();
        animalList.add(Kitten);
        animalList.add(Mojo);
        animalList.add(Dog1);
        animalList.add(Dog2);

        sortByName(animalList);

        class ComparatorOverrideBreed implements Comparator<Animal> {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getBreed().compareTo(o2.getBreed());
            }
        }
        ComparatorOverrideBreed breedCompare = new ComparatorOverrideBreed();
        Collections.sort(animalList, breedCompare);
        System.out.println("Sorting by breed:");
        System.out.println(animalList);


        //THIS PART I DID NOT FULLY UNDERSTAND!!!
        //I GOT THIS SOLUTION IN THE TUTORIAL CLASS ON WEDNESDAY NIGHT!!!
        //IT WORKS BUT IM NOT SURE EXACTLY WHY.
        //I HAVE LEFT IN THE CODE THAT I WROTE AS A COMMENT UNDERNEATH
        //PERHAPS YOU COULD TELL ME WHAT WAS WRONG?
        class ComparatorOverrideSize implements Comparator<Animal> {
            @Override
            public int compare(Animal a1, Animal a2){
                return a1.getSize() - a2.getSize();
            }


//            @Override
//            public int compare(Animal a1, Animal a2){
//                if(a1.getSize() > a2.getSize()){
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
        }
        ComparatorOverrideSize sizeCompare = new ComparatorOverrideSize();
        Collections.sort(animalList, sizeCompare);
        System.out.println("Sorting by size:");
        System.out.println(animalList);

        serializeData(animalList);
        deserializeList();
    }


    public static void sortByName(LinkedList listToSort){

        //Override the compare method to use getName
        Comparator<Animal> compareByName = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        //Sort the list by the new comparator
        Collections.sort(listToSort, compareByName);
        System.out.println(listToSort);

    }

    public static void serializeData(LinkedList<Animal> animalList){
        try {
            FileOutputStream fileOut = new FileOutputStream("output.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(animalList);
            out.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //Method to deserialize list from output.dat file
    public static void deserializeList() {

        //Create file input stream that will get input bytes from file.
        //Object input stream recovers objects that were previously serialized.
        //Store the data in listIn and print each element. Close both data streams.
        try {
            FileInputStream fileIn = new FileInputStream("output.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LinkedList<Animal> listIn = (LinkedList<Animal>) in.readObject();
            System.out.println("\nReading data from output.txt");
            for(Animal a : listIn){
                System.out.println(a.toString());
            }
            in.close();
            fileIn.close();
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
