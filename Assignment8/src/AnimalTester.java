import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AnimalTester {

    public static void main(String[] args) {

        Cat Kitten = new Cat("Kitten", "Ragdoll", 10);
        Cat Mojo = new Cat("Mojo", "Domestic Shorthair", 6);
        Dog Dog1 = new Dog("Dog1", "Bernese Mountain Dog", 9);
        Dog Dog2 = new Dog("Dog2", "Dalmation", 7);

        LinkedList<Animal> animalList = new LinkedList<>();
        animalList.add(Kitten);
        animalList.add(Mojo);
        animalList.add(Dog1);
        animalList.add(Dog2);
        
        sortByName(animalList);

    }


    public static void sortByName(LinkedList listToSort){

        Comparator<Animal> compareByName = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(listToSort, compareByName);
        System.out.println(listToSort);

    }








}
