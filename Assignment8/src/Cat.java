import java.io.Serializable;

public class Cat extends Animal implements Serializable {

    private String name;
    private String breed;
    private int size;

    public Cat(){
        super();
    }

    public Cat(String name, String breed, int size){
        super(name, breed, size);
    }

    public String sound(){
        return ""+" /\\\\_/\\\\ \n" + "/ o o \\\\ \n" + "***Meeeeeoooow***";
    }


}
