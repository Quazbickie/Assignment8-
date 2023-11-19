import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {

    private String name;
    private String breed;
    private int size;

    public Animal(){
        this("default","default",0);
    }

    public Animal(String name, String breed, int size){
        this.name = name;
        this.breed = breed;
        this.size = size;
    }

    public int compareTo(Animal animal){
        if(Objects.equals(this.name, animal.name)){
            return 1;
        } else {
            return 0;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public String getBreed(){
        return this.breed;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    public String toString(){
        return "" + this.name + " is a " + this.breed + " of size: " + this.size;
    }



}
